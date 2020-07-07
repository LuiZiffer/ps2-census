package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersEvent extends CensusCollectionImpl {

	private String character_id;
	private String achievement_id;
	private String timestamp;
	private String zone_id;
	private String world_id;
	private String event_type;
	private String table_type;
	
	public CharactersEvent() {
		super(Collection.CHARACTERS_EVENT);
		
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getTable_type() {
		return table_type;
	}

	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}

	@Override
	public String toString() {
		return "CharactersEvent [character_id=" + character_id + ", achievement_id=" + achievement_id + ", timestamp="
				+ timestamp + ", zone_id=" + zone_id + ", world_id=" + world_id + ", event_type=" + event_type
				+ ", table_type=" + table_type + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

}
