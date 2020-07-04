package census.event.dto.characterlevel;

import census.event.dto.EventPayloadObject;

public class VehicleDestroy extends EventPayloadObject {

	private String attacker_character_id;
	private String attacker_loadout_id;
	private String attacker_vehicle_id;
	private String attacker_weapon_id;
	private String character_id;
	private String facility_id;
	private String faction_id;
	private String timestamp;
	private String vehicle_id;
	private String world_id;
	private String zone_id;
	
	public VehicleDestroy() {
		super("VehicleDestroy");
	}

	public String getAttacker_character_id() {
		return attacker_character_id;
	}

	public void setAttacker_character_id(String attacker_character_id) {
		this.attacker_character_id = attacker_character_id;
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

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(String faction_id) {
		this.faction_id = faction_id;
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
		return "VehicleDestroy [attacker_character_id=" + attacker_character_id + ", attacker_loadout_id="
				+ attacker_loadout_id + ", attacker_vehicle_id=" + attacker_vehicle_id + ", attacker_weapon_id="
				+ attacker_weapon_id + ", character_id=" + character_id + ", facility_id=" + facility_id
				+ ", faction_id=" + faction_id + ", timestamp=" + timestamp + ", vehicle_id=" + vehicle_id
				+ ", world_id=" + world_id + ", zone_id=" + zone_id + "]";
	}

}
