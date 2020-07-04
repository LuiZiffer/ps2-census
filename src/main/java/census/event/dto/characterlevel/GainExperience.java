package census.event.dto.characterlevel;

import census.event.dto.EventPayloadObject;

public class GainExperience extends EventPayloadObject {

	private String amount;
	private String character_id;
	private String experience_id;
	private String loadout_id;
	private String other_id;
	private String timestamp;
	private String world_id;
	private String zone_id;
	
	public GainExperience() {
		super("GainExperience");
		// TODO Auto-generated constructor stub
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(String experience_id) {
		this.experience_id = experience_id;
	}

	public String getLoadout_id() {
		return loadout_id;
	}

	public void setLoadout_id(String loadout_id) {
		this.loadout_id = loadout_id;
	}

	public String getOther_id() {
		return other_id;
	}

	public void setOther_id(String other_id) {
		this.other_id = other_id;
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
		return "GainExperience [amount=" + amount + ", character_id=" + character_id + ", experience_id="
				+ experience_id + ", loadout_id=" + loadout_id + ", other_id=" + other_id + ", timestamp=" + timestamp
				+ ", world_id=" + world_id + ", zone_id=" + zone_id + "]";
	}

}
