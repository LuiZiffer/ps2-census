package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class VehicleFaction extends CensusCollectionImpl {

	private String vehicle_id;
	private String faction_id;
	
	public VehicleFaction() {
		super(Collection.VEHICLE_FACTION);
		// TODO Auto-generated constructor stub
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(String faction_id) {
		this.faction_id = faction_id;
	}

	@Override
	public String toString() {
		return "VehicleFaction [vehicle_id=" + vehicle_id + ", faction_id=" + faction_id + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}


}
