package census;

import census.anatomy.event.CharacterEvent;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.WorldEvent;
import census.event.listener.EventStreamListener;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Set;

public interface IStreamClient {

    public boolean connect();

    public void close() throws IOException;

    public boolean resume();

    public boolean resetConnection() throws IOException;

    public boolean unsubscribeAll() throws IllegalArgumentException, IOException;

    public boolean unsubscribe(@Nullable Set<String> worlds, @Nullable Set<String> characters, @Nullable Set<String> eventNames) throws IllegalArgumentException, IOException;

    public boolean addEventListeners(EventStreamListener... listener);

    public boolean removeEventListeners(EventStreamListener... listener);
}
