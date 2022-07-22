package census;

import java.io.Closeable;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import census.logging.LoggingConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import census.event.listener.EventStreamListener;
import census.tree.Pair;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class EventStreamHandler extends WebSocketListener implements Closeable {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final List<Pair<EventStreamListener,Boolean>> listeners = new ArrayList<>();
	
	private EventStreamClient client = null;
		
	private Map<String,Long> responsemap = new HashMap<String,Long>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -2921405087672919560L;
		/*
		{

			put("AchievementEarned", System.currentTimeMillis());
			put("BattleRankUp", System.currentTimeMillis());
			put("Death", System.currentTimeMillis());
			put("GainExperience", System.currentTimeMillis());
			put("ItemAdded", System.currentTimeMillis());
			put("PlayerFacilityCapture", System.currentTimeMillis());
			put("PlayerFacilityDefend", System.currentTimeMillis());
			put("PlayerLogin", System.currentTimeMillis());
			put("PlayerLogout", System.currentTimeMillis());
			put("SkillAdded", System.currentTimeMillis());
			put("VehicleDestroy", System.currentTimeMillis());
			put("ContinentLock", System.currentTimeMillis());
			put("ContinentUnlock", System.currentTimeMillis());
			put("FacilityControl", System.currentTimeMillis());
			put("MetagameEvent", System.currentTimeMillis());

		}*/
	};
	
	private ExecutorService eventExecutor;
	private ScheduledExecutorService heartbeatExecutor = Executors.newScheduledThreadPool(1);
	private ScheduledFuture<?> heartbeatFuture;
	
	private long missed_heartbeats = 0;
	
	private Runnable heartbeat_interval = null;
	
	private Pair<EventStreamListener,Boolean> findListenerPair(EventStreamListener listener) {
		return listeners.stream().filter(p -> p.getLeft().equals(listener)).findAny().orElse(null);
	}
	
	private List<Pair<EventStreamListener,Boolean>> findActive() {
		return listeners.stream().filter(p -> p.getRight().equals(true)).collect(Collectors.toList());
	}

	void initWatchdogTimer(String eventName) {
		responsemap.put(eventName, System.currentTimeMillis());
	}

	void disarmWatchdogTimer(String eventName) {
		responsemap.remove(eventName);
	}

	void disarmWatchdogTimer() {
		responsemap = new HashMap<>();
	}

	private void startWatchdog(long delay, long period, long maxdelay) {
		if (!heartbeatExecutor.isShutdown()) {
			logger.debug(LoggingConstants.censusEvent, "HANDLER: Starting Watchdog");
			System.out.println("HANDLER: Starting Watchdog");
			heartbeatExecutor.scheduleAtFixedRate(() -> {
				boolean isLate = false;
				for (Map.Entry<String,Long> entry : responsemap.entrySet()) {
					isLate |= TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - entry.getValue()) > maxdelay
							&& client.getBackupBuilder().getEventNames().contains(entry.getKey());
				}

				if (isLate) {
					try {
						System.out.println("WATCHDOG: Resending subscription message: " + client.getBackupBuilder().build());
						logger.debug(LoggingConstants.censusEvent,
								"WATCHDOG: Resending subscription message: " + client.getBackupBuilder().build());
						client.sendMessage(client.getBackupBuilder().build());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}, delay, period, TimeUnit.MINUTES);
		}
			
	}
	
	public EventStreamHandler(EventStreamClient client) {
		this.client = client;
		eventExecutor = Executors.newSingleThreadExecutor();
		heartbeatExecutor = Executors.newScheduledThreadPool(1);
	}
	
	public synchronized boolean register(EventStreamListener...listeners) {
		boolean regAll = true;
		for(EventStreamListener listener : listeners) {
			if (listener == null) {
				regAll = false;
				continue;
			}
			Pair<EventStreamListener,Boolean> p = findListenerPair(listener);
			
			if (p == null) {
				this.listeners.add(new Pair<>(listener,true));
			} else {
				regAll = false;
			}
		}
		return regAll;
	}
	
	public synchronized boolean unregister(EventStreamListener...listeners) {
		boolean unregAll = true;
		for(EventStreamListener listener : listeners) {
			if (listener == null) {
				unregAll = false;
			}
			Pair<EventStreamListener,Boolean> p = findListenerPair(listener);
			
			if (p != null) {
				p.setRight(false);
			} else {
				unregAll = false;
			}
		}
		return unregAll;
		
	}
	
	private void awakenClient() {
		synchronized(client) {
			if (client.isWaiting()) {
				client.notify();
				client.resetWaiting();
			}
		}
	}
	
	private void resetHeartbeat() {
		if (heartbeatFuture != null) heartbeatFuture.cancel(true);
		missed_heartbeats = 0;
		heartbeat_interval = new Runnable() {
			
			@Override
			public void run() {
				missed_heartbeats++;
				logger.debug(LoggingConstants.censusEvent,
						"HEARTBEAT: " + missed_heartbeats + "/" + CensusHttpClient.max_missed_hearbeats +
								" heartbeats missed");
				if (missed_heartbeats >= CensusHttpClient.max_missed_hearbeats) {
					heartbeatFuture.cancel(true);
					
					heartbeat_interval = null;
					client.cancel();
					logger.debug(LoggingConstants.censusEvent, "HEARTBEAT: Closing connection with interrupt. " +
							"Too many missed heartbeats");
				}
				
			}
		};
		if (!heartbeatExecutor.isShutdown())
			heartbeatFuture = heartbeatExecutor.scheduleAtFixedRate(heartbeat_interval,
					CensusHttpClient.fixed_interval_in_s, CensusHttpClient.fixed_interval_in_s, TimeUnit.SECONDS);
	}
	
	private void onSubscriptionResponse(JsonNode node) {
		Set<String> worlds = new HashSet<>();
		Set<String> eventNames = new HashSet<>();
		Set<String> characters = new HashSet<>();
		if (node.path("worlds").isArray()) {
			node.path("worlds").forEach(c -> {
				worlds.add(c.asText());
			});
		}
		if (node.path("eventNames").isArray()) {
			node.path("eventNames").forEach(c -> {
				eventNames.add(c.asText());
			});
		}
		if (node.path("characters").isArray()) {
			node.path("characters").forEach(c -> {
				characters.add(c.asText());
			});
		}
		client.getBackupBuilder().setCharacters(characters);
		client.getBackupBuilder().setWorlds(worlds);
		client.getBackupBuilder().setEventNames(eventNames);
		client.getBackupBuilder()
				.setLogicalAndCharactersWithWorlds(node.get("logicalAndCharactersWithWorlds").asBoolean());
	}
	
	private void notifyListeners(JsonNode node) {
		if(!eventExecutor.isShutdown()) {
			eventExecutor.execute(() -> {
				List<Pair<EventStreamListener,Boolean>> active = findActive();
				active.forEach(p -> {
					try {
						if (node.has("payload") && node.path("payload").has("event_name")) {
							responsemap.put(node.path("payload").path("event_name").asText(),
									System.currentTimeMillis());
						}
						p.getLeft().propagateMessage(node);
					} catch (IOException e) {
						onException(e);
					}
				});
			});
		}
	}
	
	private void propagateMessage(String message) throws IOException {
		JsonNode node = new ObjectMapper().readTree(message);

		if (node.has("online") && node.path("online").isContainerNode()) {
			resetHeartbeat();
		} else if (node.has("connected") && node.path("connected").asText().equals("true")) {
			logger.debug(LoggingConstants.censusEvent, "Connection established: " + node);
			awakenClient();
		} else if (node.has("subscription")) {
			onSubscriptionResponse(node.path("subscription"));
			notifyListeners(node);
		}
		else 
			notifyListeners(node);
		
	}
	
	public long getMissedHeartbeats() {
		return missed_heartbeats;
	}

	public void resume() {
		if (eventExecutor.isShutdown())
			eventExecutor = Executors.newSingleThreadExecutor();
		if (heartbeatExecutor.isShutdown())
			heartbeatExecutor = Executors.newScheduledThreadPool(1);
	}

	@Override
	public void onClosed(WebSocket webSocket, int code, String reason) {
		if(!eventExecutor.isShutdown()) {
			eventExecutor.submit(() -> {
				List<Pair<EventStreamListener,Boolean>> active = findActive();
				active.forEach(p -> p.getLeft().onClosed(code, reason));
			});
			close();
		}
			
	}

	@Override
	public void onClosing(WebSocket webSocket, int code, String reason) {
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(() -> {
				List<Pair<EventStreamListener,Boolean>> active = findActive();
				active.forEach(p -> p.getLeft().onClosing(code, reason));
			});
	}

	//Expect SocketException when abrupt closed (caused by heartbeat timeout), 
	//SocketTimeoutException when graceful close but connection to internet is lost
	@Override
	public void onFailure(WebSocket webSocket, Throwable t, Response response) {
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(() -> {
				List<Pair<EventStreamListener,Boolean>> active = findActive();
				active.forEach(p -> p.getLeft().onFailure(t, response));
				response.close();
			});
	}
	
	public void onException(Throwable t) {
		if (t instanceof SocketException) {
			client.cancel();
		}
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(() -> {
				List<Pair<EventStreamListener,Boolean>> active = findActive();
				active.forEach(p -> p.getLeft().onException(t));
			});
	}

	@Override
	public void onMessage(WebSocket webSocket, ByteString bytes) {
		try {
			propagateMessage(bytes.utf8());
		} catch (IOException e) {
			onException(e);
		}
	}

	@Override
	public void onMessage(WebSocket webSocket, String text) {
		try {
			propagateMessage(text);
		} catch (IOException e) {
			onException(e);
		}
	}

	@Override
	public void onOpen(WebSocket webSocket, Response response) {
		if (heartbeat_interval == null) {
			resetHeartbeat();
		}
		
		startWatchdog(2, 2, 2);
		
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> p.getLeft().onOpen(response));
					response.close();
				}
			});
	}

	@Override
	public void close() {
		logger.debug(LoggingConstants.censusEvent, "HANDLER: Shutting down");
		eventExecutor.shutdown();
		heartbeatExecutor.shutdown();
	}
	
	public boolean isClosed() {
		return eventExecutor.isShutdown() && heartbeatExecutor.isShutdown();
	}

}
