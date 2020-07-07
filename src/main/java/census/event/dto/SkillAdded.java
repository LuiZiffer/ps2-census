package census.event.dto;

public class SkillAdded extends EventPayloadObject {
	
	private String character_id;
	private String skill_id;
	private String timestamp;
	private String world_id;
	private String zone_id;

	public SkillAdded() {
		super("SkillAdded");
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
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
		return "SkillAdded [character_id=" + character_id + ", skill_id=" + skill_id + ", timestamp=" + timestamp
				+ ", world_id=" + world_id + ", zone_id=" + zone_id + "]";
	}

}
