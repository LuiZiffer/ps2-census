package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class VehicleAttachment extends CensusCollectionImpl {

	private String item_id;
	private String vehicle_id;
	private String faction_id;
	private String description;
	private String slot_id;
	
	public VehicleAttachment() {
		super(Collection.VEHICLE_ATTACHMENT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VehicleAttachment [item_id=" + item_id + ", vehicle_id=" + vehicle_id + ", faction_id=" + faction_id
				+ ", description=" + description + ", slot_id=" + slot_id + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
