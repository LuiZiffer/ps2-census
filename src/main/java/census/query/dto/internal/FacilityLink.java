package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class FacilityLink extends CensusCollectionImpl {

	private String zone_id;
	private String facility_id_a;
	private String facility_id_b;
	private String description;
	
	public FacilityLink() {
		super(Collection.FACILITY_LINK);
		// TODO Auto-generated constructor stub
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getFacility_id_a() {
		return facility_id_a;
	}

	public void setFacility_id_a(String facility_id_a) {
		this.facility_id_a = facility_id_a;
	}

	public String getFacility_id_b() {
		return facility_id_b;
	}

	public void setFacility_id_b(String facility_id_b) {
		this.facility_id_b = facility_id_b;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FacilityLink [zone_id=" + zone_id + ", facility_id_a=" + facility_id_a + ", facility_id_b="
				+ facility_id_b + ", description=" + description + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

}
