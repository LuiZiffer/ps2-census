package census.example;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import census.anatomy.event.CharacterEvent;
import census.anatomy.event.EventStreamAction;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.GenericCharacter;
import census.anatomy.event.WorldEvent;
import census.event.EventMessageBuilder;
import census.event.EventStreamClient;
import census.event.listener.EventStreamListener;
import census.event.listener.GenericEventPrinter;


/**
 * 
 * @author LuiZiffer
 * The examples here make use of the {@link Closeable} Interface.
 *  This may cause an issue where the onClosing and onClosed events of the {@link EventStreamListener} are not called.
 * <br> To demonstrate this, I have added a 2 second delay after the close() is called in syncHelpRequest. While the others do not have said delay.
 * <br> This delay solves the issue, as there is enough time before termination to call the respective Eventhandlers.
 *
 */
public class EventStreamExample {

	/**
	 * Asynchronously connects to the API, subscribes to all events, prints for 2 seconds and then disconnects and terminates
	 */
	public static void asyncPrintAll() {
		try (EventStreamClient client = EventStreamClient.getInstance()) {
			GenericEventPrinter printer = new GenericEventPrinter();
			client.addEventListeners(printer);
			client.connect();
			
			client.sendMessage(new EventMessageBuilder(EventStreamAction.SUBSCRIBE)
					.worlds(EventStreamWorld.ALL)
					.chars(GenericCharacter.ALL.toString())
					.events(CharacterEvent.ALL)
					.build());
			
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.interrupted();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Synchronously connects to the API, sends a help request message, then closes and terminates
	 */
	public static void syncHelpRequest() {
		try (EventStreamClient client = EventStreamClient.getInstance()) {
			GenericEventPrinter printer = new GenericEventPrinter();
			client.addEventListeners(printer);
			client.awaitConnection();
			client.sendHelpRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			Thread.interrupted();
			e.printStackTrace();
		}
		
	}

	/**
	 * Synchronously connects to the API, subscribes to FacilityControl events and all events on Cobalt and Miller.
	 * <br> NOTE: WorldEvent.ALL has the same effect as CharacterEvent.ALL -> enables all available events.
	 * <br> While it is possible to separately subscribe to "FacilityControl" and "all" events, it has the same effect as FacilityControl is already included in all.
	 * <br> Important here is that "all" and "FacilityControl" will show up as separate events in the SubResponse Eventhandler method.
	 * <p>
	 * After 10 seconds the connection is closed and shortly after resumed.
	 * <br> After another 10 seconds the connection closed and terminated.
	 */
	public static void syncReconnect() {
		try (EventStreamClient client = EventStreamClient.getInstance()) {
			GenericEventPrinter printer = new GenericEventPrinter();
			client.addEventListeners(printer);
			client.awaitConnection();
			
			client.subscribe(EventStreamWorld.COBALT, WorldEvent.FACILITY_CONTROL);
			client.subscribe(EventStreamWorld.MILLER, WorldEvent.ALL);
			client.subscribe(GenericCharacter.ALL.toString(), CharacterEvent.GAIN_EXPERIENCE);
			
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.interrupted();
			}
			
			try {
				client.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.interrupted();
			}
			client.resume();
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.interrupted();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
