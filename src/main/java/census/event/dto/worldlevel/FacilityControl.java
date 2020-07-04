package census.event.dto.worldlevel;

import census.event.dto.EventPayloadObject;

public class FacilityControl extends EventPayloadObject {

	private String duration_held;
	private String facility_id;
	private String new_faction_id;
	private String old_faction_id;
	private String outfit_id;
	private String timestamp;
	private String world_id;
	private String zone_id;
	
	public FacilityControl() {
		super("FacilityControl");
	}

	public String getDuration_held() {
		return duration_held;
	}

	public void setDuration_held(String duration_held) {
		this.duration_held = duration_held;
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getNew_faction_id() {
		return new_faction_id;
	}

	public void setNew_faction_id(String new_faction_id) {
		this.new_faction_id = new_faction_id;
	}

	public String getOld_faction_id() {
		return old_faction_id;
	}

	public void setOld_faction_id(String old_faction_id) {
		this.old_faction_id = old_faction_id;
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
		return "FacilityControl [duration_held=" + duration_held + ", facility_id=" + facility_id + ", new_faction_id="
				+ new_faction_id + ", old_faction_id=" + old_faction_id + ", outfit_id=" + outfit_id + ", timestamp="
				+ timestamp + ", world_id=" + world_id + ", zone_id=" + zone_id + "]";
	}

}
