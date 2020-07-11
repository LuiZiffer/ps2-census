package test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import census.event.dto.GainExperience;

class EventStreamClientTest {

	@Test
	void test() {
		String input = "{\"amount\":\"96\",\"character_id\":\"5429018053084408945\",\"event_name\":\"GainExperience\",\"experience_id\":\"2\",\"loadout_id\":\"1\",\"other_id\":\"5428510351673779425\",\"timestamp\":\"1593765908\",\"world_id\":\"1\",\"zone_id\":\"2\"}";
		try {
			GainExperience event = new ObjectMapper().readValue(input, GainExperience.class);
			System.out.println(event);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//EventStreamExample.syncReconnect();
		//EventStreamExample.asyncPrintAll();
		
		//EventStreamExample.syncHelpRequest();
	}

}
