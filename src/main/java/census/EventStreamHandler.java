package census;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import census.event.listener.EventStreamListener;
import census.tree.Pair;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class EventStreamHandler extends WebSocketListener implements Closeable {
	
	private List<Pair<EventStreamListener,Boolean>> listeners = new ArrayList<>();
	
	private EventStreamClient client = EventStreamClient.getInstance();
	
	private ExecutorService eventExecutor;
	private ScheduledExecutorService heartbeatExecutor = Executors.newScheduledThreadPool(1);
	private ScheduledFuture<?> heartbeatFuture;
	
	private long missed_heartbeats = 0;
	
	private Runnable heartbeat_interval = null;
	
	private Pair<EventStreamListener,Boolean> findListenerPair(EventStreamListener listener) {
		return listeners.stream().filter(p -> p.left().equals(listener)).findAny().orElse(null);
	}
	
	private List<Pair<EventStreamListener,Boolean>> findActive() {
		return listeners.stream().filter(p -> p.right().equals(true)).collect(Collectors.toList());
	}
	
	public EventStreamHandler() {
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
	
	private final void resetHeartbeat() {
		if (heartbeatFuture != null) heartbeatFuture.cancel(true);
		missed_heartbeats = 0;
		//System.out.println("Resetting Heartbeat");
		heartbeat_interval = new Runnable() {
			
			@Override
			public void run() {
				missed_heartbeats++;
				//System.out.println("Heartbeat: " + missed_heartbeats);
				if (missed_heartbeats >= CensusHttpClient.max_missed_hearbeats) {
					heartbeatFuture.cancel(true);
					//System.out.println("Closing Connection");
					
					heartbeat_interval = null;
					try {
						client.close(1000,"Closing connection. Too many missed heartbeats");
						//System.out.println("Graceful close: " + ret);
					} catch (IOException e) {
						onException(e);
					}
				}
				
			}
		};
		if (!heartbeatExecutor.isShutdown())
			heartbeatFuture = heartbeatExecutor.scheduleAtFixedRate(heartbeat_interval, CensusHttpClient.fixed_interval_in_s, CensusHttpClient.fixed_interval_in_s, TimeUnit.SECONDS);
	}
	
	private final void onSubscriptionResponse(JsonNode node) {
		List<String> worlds = new ArrayList<>();
		List<String> eventNames = new ArrayList<>();
		List<String> characters = new ArrayList<>();
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
		client.getBackupBuilder().setLogicalAndCharactersWithWorlds(node.get("logicalAndCharactersWithWorlds").asBoolean());
	}
	
	private final void notifyListeners(JsonNode node) {
		if(!eventExecutor.isShutdown()) {
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> {
						try {
							p.left().propagateMessage(node);
						} catch (IOException e) {
							onException(e);
						}
					});
				}
			});
		}
	}
	
	private final void propagateMessage(String message) throws IOException {
		JsonNode node = new ObjectMapper().readTree(message);

		if (node.has("online") && node.path("online").isContainerNode()) {
			resetHeartbeat();
		} else if (node.has("connected") && node.path("connected").asText().equals("true")) {
			awakenClient();
		} else if (node.has("subscription")) {
			onSubscriptionResponse(node.path("subscription"));
			notifyListeners(node);
		}
		else 
			notifyListeners(node);
		
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
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> p.left().onClosed(code, reason));
				}
			});
			close();
		}
			
	}

	@Override
	public void onClosing(WebSocket webSocket, int code, String reason) {
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> p.left().onClosing(code, reason));
				}
			});
	}

	//Expect SocketException when abrupt closed (caused by heartbeat timeout), 
	//SocketTimeoutException when graceful close but connection to internet is lost
	@Override
	public void onFailure(WebSocket webSocket, Throwable t, Response response) {
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> p.left().onFailure(t, response));
					response.close();
				}
			});
	}
	
	public void onException(Throwable t) {
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> p.left().onException(t));
				}
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
		if(!eventExecutor.isShutdown())
			eventExecutor.submit(new Runnable() {
				
				@Override
				public void run() {
					List<Pair<EventStreamListener,Boolean>> active = findActive();
					active.forEach(p -> p.left().onOpen(response));
					response.close();
				}
			});
	}

	@Override
	public void close() {
		eventExecutor.shutdown();
		heartbeatExecutor.shutdown();
	}

}
