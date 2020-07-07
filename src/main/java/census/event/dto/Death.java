package census.event.dto;

public class Death extends EventPayloadObject {

	private String attacker_character_id;
	private String attacker_fire_mode_id;
	private String attacker_loadout_id;
	private String attacker_vehicle_id;
	private String attacker_weapon_id;
	private String character_id;
	private String character_loadout_id;
	private String is_critical;
	private String is_headshot;
	private String timestamp;
	private String vehicle_id;
	private String world_id;
	private String zone_id;
	
	public Death() {
		super("Death");
	}

	public String getAttacker_character_id() {
		return attacker_character_id;
	}

	public void setAttacker_character_id(String attacker_character_id) {
		this.attacker_character_id = attacker_character_id;
	}

	public String getAttacker_fire_mode_id() {
		return attacker_fire_mode_id;
	}

	public void setAttacker_fire_mode_id(String attacker_fire_mode_id) {
		this.attacker_fire_mode_id = attacker_fire_mode_id;
	}

	public String getAttacker_loadout_id() {
		return attacker_loadout_id;
	}

	public void setAttacker_loadout_id(String attacker_loadout_id) {
		this.attacker_loadout_id = attacker_loadout_id;
	}

	public String getAttacker_vehicle_id() {
		return attacker_vehicle_id;
	}

	public void setAttacker_vehicle_id(String attacker_vehicle_id) {
		this.attacker_vehicle_id = attacker_vehicle_id;
	}

	public String getAttacker_weapon_id() {
		return attacker_weapon_id;
	}

	public void setAttacker_weapon_id(String attacker_weapon_id) {
		this.attacker_weapon_id = attacker_weapon_id;
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getCharacter_loadout_id() {
		return character_loadout_id;
	}

	public void setCharacter_loadout_id(String character_loadout_id) {
		this.character_loadout_id = character_loadout_id;
	}

	public String getIs_critical() {
		return is_critical;
	}

	public void setIs_critical(String is_critical) {
		this.is_critical = is_critical;
	}

	public String getIs_headshot() {
		return is_headshot;
	}

	public void setIs_headshot(String is_headshot) {
		this.is_headshot = is_headshot;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
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
		return "Death [attacker_character_id=" + attacker_character_id + ", attacker_fire_mode_id="
				+ attacker_fire_mode_id + ", attacker_loadout_id=" + attacker_loadout_id + ", attacker_vehicle_id="
				+ attacker_vehicle_id + ", attacker_weapon_id=" + attacker_weapon_id + ", character_id=" + character_id
				+ ", character_loadout_id=" + character_loadout_id + ", is_critical=" + is_critical + ", is_headshot="
				+ is_headshot + ", timestamp=" + timestamp + ", vehicle_id=" + vehicle_id + ", world_id=" + world_id
				+ ", zone_id=" + zone_id + "]";
	}

}
