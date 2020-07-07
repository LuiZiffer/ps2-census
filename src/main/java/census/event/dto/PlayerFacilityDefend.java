package census.event.dto;

public class PlayerFacilityDefend extends EventPayloadObject {

	private String character_id;
	private String facility_id;
	private String outfit_id;
	private String timestamp;
	private String world_id;
	private String zone_id;
	
	public PlayerFacilityDefend() {
		super("PlayerFacilityDefend");
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getOutfit_id() {
		return outfit_id;
	}

	public void setOutfit_id(String outfit_id) {
		this.outfit_id = outfit_id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	@Override
	public String toString() {
		return "PlayerFacilityDefend [character_id=" + character_id + ", facility_id=" + facility_id + ", outfit_id="
				+ outfit_id + ", timestamp=" + timestamp + ", world_id=" + world_id + ", zone_id=" + zone_id + "]";
	}

}
