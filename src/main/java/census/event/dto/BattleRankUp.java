package census.event.dto;

public class BattleRankUp extends EventPayloadObject {

	private String battle_rank;
	private String character_id;
	private String timestamp;
	private String world_id;
	private String zone_id;
	
	public BattleRankUp() {
		super("BattleRankUp");
	}

	public String getBattle_rank() {
		return battle_rank;
	}

	public void setBattle_rank(String battle_rank) {
		this.battle_rank = battle_rank;
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

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	@Override
	public String toString() {
		return "BattleRankUp [battle_rank=" + battle_rank + ", character_id=" + character_id + ", timestamp="
				+ timestamp + ", world_id=" + world_id + ", zone_id=" + zone_id + "]";
	}

}
