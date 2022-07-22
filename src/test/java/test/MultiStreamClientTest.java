package test;

import census.EventStreamClient;
import census.MultiStreamClient;
import census.anatomy.event.CharacterEvent;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.WorldEvent;
import census.event.listener.EventStreamListener;
import census.event.listener.GenericEventPrinter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MultiStreamClientTest {

    @Test
    void test() {
        try (MultiStreamClient client = new MultiStreamClient()) {
            System.out.println(client.addEventListeners(new GenericEventPrinter()));
            System.out.println(client.connect("cobalt"));
            System.out.println(client.addEventListeners(new GenericEventPrinter()));
            System.out.println(client.addEventListeners(new GenericEventPrinter()));
            client.subscribe("cobalt", EventStreamWorld.COBALT, WorldEvent.CONTINENT_LOCK);
            client.subscribe("miller", EventStreamWorld.COBALT, WorldEvent.FACILITY_CONTROL);
            System.out.println(client.connect("miller"));
            client.subscribe("miller", EventStreamWorld.MILLER, WorldEvent.CONTINENT_LOCK);
            Thread.sleep(300000);
            client.close();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
