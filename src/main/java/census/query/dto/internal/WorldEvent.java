package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class WorldEvent extends CensusCollectionImpl {

	private String facility_id;
	private String faction_old;
	private String faction_new;
	private String duration_held;
	private String objective_id;
	private String timestamp;
	private String zone_id;
	private String world_id;
	private String event_type;
	private String table_type;
	private String outfit_id;
	
	public WorldEvent() {
		super(Collection.WORLD_EVENT);
		// TODO Auto-generated constructor stub
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getFaction_old() {
		return faction_old;
	}

	public void setFaction_old(String faction_old) {
		this.faction_old = faction_old;
	}

	public String getFaction_new() {
		return faction_new;
	}

	public void setFaction_new(String faction_new) {
		this.faction_new = faction_new;
	}

	public String getDuration_held() {
		return duration_held;
	}

	public void setDuration_held(String duration_held) {
		this.duration_held = duration_held;
	}

	public String getObjective_id() {
		return objective_id;
	}

	public void setObjective_id(String objective_id) {
		this.objective_id = objective_id;
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

	public String getOutfit_id() {
		return outfit_id;
	}

	public void setOutfit_id(String outfit_id) {
		this.outfit_id = outfit_id;
	}

	@Override
	public String toString() {
		return "WorldEvent [facility_id=" + facility_id + ", faction_old=" + faction_old + ", faction_new="
				+ faction_new + ", duration_held=" + duration_held + ", objective_id=" + objective_id + ", timestamp="
				+ timestamp + ", zone_id=" + zone_id + ", world_id=" + world_id + ", event_type=" + event_type
				+ ", table_type=" + table_type + ", outfit_id=" + outfit_id + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
