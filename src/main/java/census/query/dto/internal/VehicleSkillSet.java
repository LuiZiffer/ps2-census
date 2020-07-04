package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class VehicleSkillSet extends CensusCollectionImpl {

	private String vehicle_id;
	private String skill_set_id;
	private String faction_id;
	private String display_index;
	
	public VehicleSkillSet() {
		super(Collection.VEHICLE_SKILL_SET);
		// TODO Auto-generated constructor stub
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getSkill_set_id() {
		return skill_set_id;
	}

	public void setSkill_set_id(String skill_set_id) {
		this.skill_set_id = skill_set_id;
	}

	public String getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(String faction_id) {
		this.faction_id = faction_id;
	}

	public String getDisplay_index() {
		return display_index;
	}

	public void setDisplay_index(String display_index) {
		this.display_index = display_index;
	}

	@Override
	public String toString() {
		return "VehicleSkillSet [vehicle_id=" + vehicle_id + ", skill_set_id=" + skill_set_id + ", faction_id="
				+ faction_id + ", display_index=" + display_index + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

	

}
