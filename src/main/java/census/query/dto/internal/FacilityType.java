package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class FacilityType extends CensusCollectionImpl {

	private String facility_type_id;
	private String description;
	
	public FacilityType() {
		super(Collection.FACILITY_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getFacility_type_id() {
		return facility_type_id;
	}

	public void setFacility_type_id(String facility_type_id) {
		this.facility_type_id = facility_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FacilityType [facility_type_id=" + facility_type_id + ", description=" + description
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	
}
