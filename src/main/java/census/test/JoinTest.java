package census.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import census.anatomy.Collection;
import census.query.Join;

class JoinTest {

	@Test
	void testToString() {
		String compare = "outfit_member^on:outfit_id^list:1^inject_at:members^show:character_id'rank'rank_ordinal"
				+ "(character^show:name^inject_at:character"
				+ "(characters_online_status^inject_at:onlineStatus^hide:character_id))";
		Join outer = new Join(Collection.OUTFIT_MEMBER)
				.on("outfit_id")
				.list(1)
				.inject_at("members")
				.show("character_id", "rank", "rank_ordinal");
		Join middle = new Join(Collection.CHARACTER)
				.show("name")
				.inject_at("character");
		Join inner = new Join(Collection.CHARACTERS_ONLINE_STATUS)
				.inject_at("onlineStatus")
				.hide("character_id");
		outer.join(middle.join(inner));
		
		assertEquals(compare, outer.toString());
	}

}
