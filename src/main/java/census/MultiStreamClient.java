package census;

import census.anatomy.Constants;
import census.anatomy.event.CharacterEvent;
import census.anatomy.event.EventEnvironment;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.WorldEvent;
import census.event.listener.EventStreamListener;
import org.jetbrains.annotations.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;

public class MultiStreamClient implements Closeable, IStreamClient {

    private final Map<String, EventStreamClient> clientMap = new HashMap<>();
    private final Set<EventStreamListener> listeners = new HashSet<>();

    public boolean connect(String streamIdentifier, EventEnvironment env, String service_id, String alternate_endpoint) {
        synchronized (clientMap) {
            if (clientMap.get(streamIdentifier) != null) return false;
            else {
                EventStreamClient client = new EventStreamClient();
                EventStreamHandler handler = new EventStreamHandler(client);
                client.setEventStreamHandler(handler);
                handler.register(listeners.toArray(new EventStreamListener[0]));
                clientMap.put(streamIdentifier, client);
                return client.connect(env, service_id, alternate_endpoint);
            }
        }
    }

    public boolean connect(String streamIdentifier, EventEnvironment env, String service_id) {
        return connect(streamIdentifier, env, service_id, null);
    }

    public boolean connect(String streamIdentifier, EventEnvironment env) {
        return connect(streamIdentifier, env, Constants.EXAMPLE_SERVICE_ID.toString());
    }

    public boolean connect(String streamIdentifier) {
        return connect(streamIdentifier, EventEnvironment.PS2);
    }

    public boolean connect() {
        boolean success = false;
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    success |= client.connect();
                }
            }
            return success;
        }
    }

    public boolean close(String streamIdentifier, int code, String reason) throws IOException {
        synchronized (clientMap) {
            EventStreamClient client = clientMap.get(streamIdentifier);
            if (client != null && client.isConnected()) {
                return client.close(code, reason);
            }
            return false;
        }
    }

    public void close(String streamIdentifier) throws IOException {
        close(streamIdentifier, 1000,"closing");
    }

    public void close() throws IOException {
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    client.close();
                }
            }
        }
    }

    public boolean resume(String streamIdentifier) {
        synchronized (clientMap) {
            EventStreamClient client = clientMap.get(streamIdentifier);
            if (client != null) {
                return client.resume();
            }
            return false;
        }
    }

    public boolean resume() {
        boolean success = false;
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    success |= client.resume();
                }
            }
            return success;
        }
    }

    public boolean resetConnection(String streamIdentifier) throws IOException {
        synchronized (clientMap) {
            EventStreamClient client = clientMap.get(streamIdentifier);
            if (client != null) {
                return client.resetConnection();
            }
            return false;
        }
    }

    public boolean resetConnection() throws IOException {
        boolean success = false;
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    success |= client.resetConnection();
                }
            }
            return success;
        }
    }

    public boolean subscribe(String streamIdentifier, EventStreamWorld world, WorldEvent event) throws IOException {
        EventStreamClient client = clientMap.get(streamIdentifier);
        if (client != null) {
            return client.subscribe(world, event);
        }
        return false;
    }

    public boolean subscribe(String streamIdentifier, String character, CharacterEvent event) throws IOException {
        EventStreamClient client = clientMap.get(streamIdentifier);
        if (client != null) {
            return client.subscribe(character, event);
        }
        return false;
    }

    public boolean subscribe(String streamIdentifier, EventStreamWorld world, String character, CharacterEvent event) throws IOException {
        EventStreamClient client = clientMap.get(streamIdentifier);
        if (client != null) {
            return client.subscribe(world, character, event);
        }
        return false;
    }

    public boolean unsubscribeAll() throws IllegalArgumentException, IOException {
        boolean success = false;
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    success |= client.unsubscribeAll();
                }
            }
            return success;
        }
    }

    public boolean unsubscribe(@Nullable Set<String> worlds, @Nullable Set<String> characters, @Nullable Set<String> eventNames) throws IllegalArgumentException, IOException {
        boolean success = false;
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    success |= client.unsubscribe(worlds, characters, eventNames);
                }
            }
            return success;
        }
    }

    public boolean addEventListeners(EventStreamListener... listener) {
        boolean success = false;
        synchronized (clientMap) {
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    listeners.addAll(Arrays.asList(listener));
                    success |= client.addEventListeners(listener);
                }
            }
            return success;
        }
    }

    public boolean removeEventListeners(EventStreamListener... listener) {
        boolean success = false;
        synchronized (clientMap) {
            Arrays.asList(listener).forEach(listeners::remove);
            for (EventStreamClient client : clientMap.values()) {
                if (client != null) {
                    success |= client.removeEventListeners(listener);
                }
            }
            return success;
        }
    }

    public EventStreamClient getClient(String streamIdentifier) {
        return clientMap.get(streamIdentifier);
    }
}
