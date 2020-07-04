package census.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import census.anatomy.event.EventStreamAction;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.GenericCharacter;
import census.anatomy.event.WorldEvent;
import census.event.EventMessageBuilder;

class EventSubscriptionBuilderTest {

	@Test
	void testBuild() {
		String comp1 = "{\"service\":\"event\",\"action\":\"subscribe\",\"worlds\":[],\"characters\":[\"all\"],\"eventNames\":[\"GainExperience_experience_id_1\"],\"logicalAndCharactersWithWorlds\":false,\"all\":false}";
		String comp2 = "{\"service\":\"event\",\"action\":\"subscribe\",\"worlds\":[\"1\",\"19\",\"10\"],\"characters\":[],\"eventNames\":[\"FacilityControl\",\"MetagameEvent\"],\"logicalAndCharactersWithWorlds\":false,\"all\":false}";
		String comp3 = "{\"service\":\"event\",\"action\":\"clearSubscribe\",\"worlds\":[],\"characters\":[],\"eventNames\":[],\"logicalAndCharactersWithWorlds\":false,\"all\":true}";
		EventMessageBuilder builder = new EventMessageBuilder(EventStreamAction.SUBSCRIBE);
		
		builder
			.chars(GenericCharacter.ALL.toString())
			.gainExperienceEvents(1);
		JsonNode node = builder.build();
		//System.out.println(node);
		assertEquals(comp1, node.toString());
		
		builder = new EventMessageBuilder(EventStreamAction.SUBSCRIBE)
				.worlds(EventStreamWorld.CONNERY, EventStreamWorld.JAEGER, EventStreamWorld.MILLER)
				.events(WorldEvent.FACILITY_CONTROL, WorldEvent.METAGAME_EVENT);
		node = builder.build();
		//System.out.println(node);
		assertEquals(comp2, node.toString());
		
		builder = new EventMessageBuilder(EventStreamAction.CLEAR_SUBSCRIBE)
				.all(true);
		node = builder.build();
		//System.out.println(node);
		assertEquals(comp3, node.toString());
	}
	
	@Test
	void serializationTest() {
		EventMessageBuilder builder = new EventMessageBuilder(EventStreamAction.SUBSCRIBE);
		
		builder
			.chars(GenericCharacter.ALL.toString())
			.gainExperienceEvents(1)
			.worlds(EventStreamWorld.CONNERY, EventStreamWorld.JAEGER, EventStreamWorld.MILLER)
			.events(WorldEvent.FACILITY_CONTROL, WorldEvent.METAGAME_EVENT);
		
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("EventSubscriptionBuilder.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(builder);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized data is saved in EventSubscriptionBuilder.ser");
	    } catch (IOException i) {
	         i.printStackTrace();
	    }
		
		EventMessageBuilder e = null;
		try {
	         FileInputStream fileIn = new FileInputStream("EventSubscriptionBuilder.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (EventMessageBuilder) in.readObject();
	         in.close();
	         fileIn.close();
	    } catch (IOException i) {
	         i.printStackTrace();
	         return;
	    } catch (ClassNotFoundException c) {
	         System.out.println("EventSubscriptionBuilder class not found");
	         c.printStackTrace();
	         return;
	    }
		
		System.out.println(e);
		
	}

}
