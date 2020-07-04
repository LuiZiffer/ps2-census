package census.event.dto.characterlevel;

import census.event.dto.EventPayloadObject;

public class AchievementEarned extends EventPayloadObject {

	private String character_id;
	private String timestamp;
	private String world_id;
	private String achievement_id;
	private String zone_id;
	
	public AchievementEarned() {
		super("AchievementEarned");
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
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

	public String getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	@Override
	public String toString() {
		return "AchievementEarned [character_id=" + character_id + ", timestamp=" + timestamp + ", world_id=" + world_id
				+ ", achievement_id=" + achievement_id + ", zone_id=" + zone_id + "]";
	}

}
