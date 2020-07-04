package census.event;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.Nullable;

import com.fasterxml.jackson.databind.JsonNode;
import census.CensusHttpClient;
import census.anatomy.Constants;
import census.anatomy.event.CharacterEvent;
import census.anatomy.event.EventEnvironment;
import census.anatomy.event.EventStreamAction;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.GenericCharacter;
import census.anatomy.event.WorldEvent;
import census.event.listener.EventStreamListener;
import census.event.listener.GenericEventPrinter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * 
 * @author LuiZiffer
 * 
 * This is a wrapper class for the WebSocket connection to the Census API Event Stream.<br>
 * Events are handled by the {@link EventStreamListener}s registered in this client.
 * <p>
 * The Lifecycle of the WebSocket connection viewed from a {@link EventStreamListener}: <br>
 * onOpen() -> [onMessage()...] -> onClosing() -> onClosed()
 * <br><br>
 * or:<br>
 * onOpen() -> [onMessage()...] -> onFailure()
 * <p>
 * If a disconnect occurs, the connection will stay open for 3 heartbeats or roughly 90 seconds.<br>
 * After 3 heartbeats the client will close the connection. <br>
 * If the Census API server cannot be reached, the {@link EventStreamListener} onFailure method will be called.<br>
 * <p>
 * If such a disconnect has occurred, the connection can be reestablished by calling the resume() method.<br>
 * <p>
 * To subscribe to an event either call the corresponding subscribe(...) method or manually generate a subscription message using {@link EventMessageBuilder}.build().
 * All successful subscriptions are stored in a local variable, 
 * 	so that if the connection is closed it can be directly resumed, without having to manually resubscribe to all events.
 * <p>
 * Unsubscribing from an event also removes the event from the backup variable.<br>
 * For an in depth description of the Census Event Stream see {@link http://census.daybreakgames.com/#what-is-websocket}.
 * <p>
 * A {@link GenericEventPrinter} is provided as a default Listener if you only want to print the events.
 * <p>
 * It is recommended you use your personal unique service id generated on the website instead of the default one. (The client will still work with s:example of course). <br>
 * The default environment is PS2, meaning PC and can be changed to PS4.
 * <p>
 * For establishing a connection with the server, you have the options awaitConnection() to synchronously connect (i.e. the thread pauses until a connection has been established)
 *  or connect() to asynchronously connect.<br>
 * Attempting to send a message while the connection is not (yet) established, will cause the message to be queued and sent once the connection is OPEN.
 *
 */
public final class EventStreamClient implements Closeable {

	private static EventStreamClient instance;
	private EventStreamHandler handler;
	private OkHttpClient client;
	private WebSocket webSocket;
	private String service_id = Constants.EXAMPLE_SERVICE_ID.toString();
	private EventEnvironment env = EventEnvironment.PS2;
	private boolean isWaiting = false;
	
	private EventMessageBuilder backupBuilder = new EventMessageBuilder(EventStreamAction.SUBSCRIBE);
	
	private void setEventStreamHandler(EventStreamHandler handler) {
		this.handler = handler;
	}
	
	private EventStreamClient() {
		client = CensusHttpClient.getHttpClient();
	}
	
	
	/**
	 * Asynchronously establishes a connection with the Census API Event Stream according to the set parameters.
	 * @param env The Environment to connect to (PC, PS4)
	 * @param service_id Unique Id for accessing the API
	 * @return true when a new WebSocket has been created
	 * <br>    false when any argument is null or the {@link EventStreamHandler} is null.
	 */
	public synchronized boolean connect(EventEnvironment env, String service_id) {
		if (handler == null || env == null || service_id == null) return false;
		this.env = env;
		this.service_id = service_id;
		webSocket = client.newWebSocket(new Request.Builder()
				.url(Constants.PUSH_ENDPOINT + "?environment=" + env + "&service-id=" + Constants.SERVICE_ID_PREFIX + service_id)
				.build(), handler);
		return true;
	}
	
	/**
	 * Asynchronously establishes a connection with the Census API Event Stream according to the set parameters.
	 * @param env The Environment to connect to (PC, PS4)
	 * @return true when a new WebSocket has been created
	 * <br>    false when any argument is null or the {@link EventStreamHandler} is null.
	 */
	public synchronized boolean connect(EventEnvironment env) {
		return connect(env, service_id);
	}
	
	/**
	 * Asynchronously establishes a connection with the Census API Event Stream according to the set parameters.
	 * @return true when a new WebSocket has been created
	 * <br>    false when any argument is null or the {@link EventStreamHandler} is null.
	 */
	public synchronized boolean connect() {
		return connect(env);
	}
	
	/**
	 * Synchronously establishes a connection with the Census API Event Stream according to the set parameters.
	 * @param env The Environment to connect to (PC, PS4)
	 * @param service_id service_id Unique Id for accessing the API
	 */
	public synchronized void awaitConnection(EventEnvironment env, String service_id) {
		isWaiting = true;
		connect(env,service_id);
		try {
			wait();
		} catch (InterruptedException e) {
			Thread.interrupted();
			handler.onException(e);
		}
	}
	
	/**
	 * Synchronously establishes a connection with the Census API Event Stream according to the set parameters.
	 * @param env The Environment to connect to (PC, PS4)
	 */
	public synchronized void awaitConnection(EventEnvironment env) {
		awaitConnection(env, service_id);
	}
	
	/**
	 * Synchronously establishes a connection with the Census API Event Stream according to the set parameters.
	 */
	public synchronized void awaitConnection() {
		awaitConnection(env);
	}
	
	
	/**
	 * 
	 * @return Instance of the {@link EventStreamClient} object.
	 */
	public static synchronized EventStreamClient getInstance() {
		if (instance == null) {
			instance = new EventStreamClient();
			instance.setEventStreamHandler(new EventStreamHandler());
		}
		return instance;
	}
	
	/**
	 * Closes the connection
	 * @param code
	 * @param reason
	 * @return true if the connection is not already closed or cancelled
	 * @throws IOException
	 */
	public synchronized boolean close(int code, String reason) throws IOException {
		boolean tmp = false;
		if (webSocket != null) {
			tmp = webSocket.close(code, reason);
			
			webSocket = null;
		}
		return tmp;
	}
	
	/**
	 * Closes the connection with code 1000 and reason "closing"
	 */
	public synchronized void close() throws IOException {
		close(1000,"closing");
	}
	
	/**
	 * Resumes the connection if the connection is closed or cancelled
	 * @return true if the connection is/was closed or cancelled
	 */
	public synchronized boolean resume() {
		if (webSocket == null) {
			handler.resume();
			connect();
			return sendMessage(backupBuilder.build());
		}
		return false;
	}
	
	
	
	synchronized void resetWaiting() {
		this.isWaiting = false;
	}

	/**
	 * @return true if the client is waiting for a connection to be established (Caused by awaitConnection(...))
	 */
	public synchronized boolean isWaiting() {
		return isWaiting;
	}

	//Getters and Setters
	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public EventEnvironment getEnvironment() {
		return env;
	}

	public void setEnvironment(EventEnvironment env) {
		this.env = env;
	}

	public EventMessageBuilder getBackupBuilder() {
		return backupBuilder;
	}
	
	public EventStreamHandler getEventStreamHandler() {
		return handler;
	}
	
	
	/**
	 * Adds an {@link EventStreamListener} to the client
	 * @param listener
	 * @return true if listener was added
	 */
	public boolean addEventListeners(EventStreamListener listener) {
		if (handler == null) return false;
		return handler.register(listener);
	}

	/**
	 * Removes an {@link EventStreamListener}
	 * @param listener
	 * @return true if listener was removed
	 */
	public boolean removeEventListeners(EventStreamListener listener) {
		if (handler == null) return false;
		return handler.unregister(listener);
	}
	
	/**
	 * Sends a JSON format String message to the Census API Event Stream server.
	 * @param message
	 * @return true if message was sent or queued
	 */
	public synchronized boolean sendMessage(String message) {
		return webSocket.send(message);
	}
	
	/**
	 * Sends a JSON format {@link JsonNode} message to the Census API Event Stream server.
	 * @param message
	 * @return true if message was sent or queued
	 */
	public synchronized boolean sendMessage(JsonNode node) {
		return sendMessage(node.toString());
	}
	
	/**
	 * Sends a help message to the Census API Event Stream server.
	 * @return true if message was sent or queued
	 */
	public boolean sendHelpRequest() {
		return sendMessage("{\"service\":\"event\",\"action\":\"help\"}");
	}
	
	/**
	 * Sends a subscription message.
	 * @param world The world to subscribe to
	 * @param event
	 * @return true if message was sent or queued
	 */
	public boolean subscribe(EventStreamWorld world, WorldEvent event) {
		return sendMessage(new EventMessageBuilder(EventStreamAction.SUBSCRIBE)
				.worlds(world)
				.events(event)
				.build());
	}
	
	/**
	 * Sends a subscription message.
	 * @param character The character id or a {@link GenericCharacter} to subscribe to
	 * @param event
	 * @return true if message was sent or queued
	 */
	public boolean subscribe(String character, CharacterEvent event) {
		return sendMessage(new EventMessageBuilder(EventStreamAction.SUBSCRIBE)
				.chars(character)
				.events(event)
				.build());
	}
	
	/**
	 * Sends a subscription message with logicalAndCharactersWithWorlds set to true.
	 * @param world The world to subscribe to
	 * @param character The character id or a {@link GenericCharacter} to subscribe to
	 * @param event
	 * @return true if message was sent or queued
	 */
	public boolean subscribe(EventStreamWorld world, String character, CharacterEvent event) {
		return sendMessage(new EventMessageBuilder(EventStreamAction.SUBSCRIBE)
				.worlds(world)
				.chars(character)
				.events(event)
				.logicalAndCharactersWithWorlds(true)
				.build());
	}
	
	/**
	 * Clears all subscriptions.
	 * @return true if message was sent or queued
	 */
	public boolean unsubscribeAll() {
		backupBuilder = new EventMessageBuilder(EventStreamAction.SUBSCRIBE);
		return sendMessage(new EventMessageBuilder(EventStreamAction.CLEAR_SUBSCRIBE)
				.all(true)
				.build());
	}
	
	/**
	 * Unsubscribe from a specific event, character and/or world.
	 * <br> If all passed parameters are null the method unsubscribeAll will be called.
	 * @param worlds
	 * @param characters
	 * @param eventNames
	 * @return true if message was sent or queued
	 */
	public boolean unsubscribe(@Nullable List<String> worlds,@Nullable List<String> characters,@Nullable List<String> eventNames) {
		EventMessageBuilder builder = new EventMessageBuilder(EventStreamAction.CLEAR_SUBSCRIBE);
		if ((worlds == null || worlds.isEmpty()) 
				&& (characters == null || characters.isEmpty())
				&& (eventNames == null || eventNames.isEmpty()))
			return unsubscribeAll();
		
		else {
			if (worlds != null) {
				builder.setWorlds(worlds);
				backupBuilder.getWorlds().removeAll(worlds);
			}
			if (characters != null) {
				builder.setCharacters(characters);
				backupBuilder.getCharacters().removeAll(characters);
			}
			if (eventNames != null) {
				builder.setEventNames(eventNames);
				backupBuilder.getEventNames().removeAll(eventNames);
			}
			return sendMessage(builder.build());
		}
	}
	
	/**
	 * Sets the logicalAndCharactersWithWorlds variable to false
	 * @return true if message was sent or queued
	 */
	public boolean resetLogicalAndCharactersWithWorlds() {
		backupBuilder.setLogicalAndCharactersWithWorlds(false);
		return sendMessage(new EventMessageBuilder(EventStreamAction.CLEAR_SUBSCRIBE).logicalAndCharactersWithWorlds(false).build());
	}
	
	/**
	 * 
	 * @return true if Websocket is connected
	 */
	public boolean isConnected() {
		return webSocket != null;
	}
	
}
