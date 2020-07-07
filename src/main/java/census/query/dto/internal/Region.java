package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class Region extends CensusCollectionImpl {

	private String region_id;
	private String zone_id;
	private String initial_faction_id;
	private LanguageObject name;
	
	public Region() {
		super(Collection.REGION);
		// TODO Auto-generated constructor stub
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getInitial_faction_id() {
		return initial_faction_id;
	}

	public void setInitial_faction_id(String initial_faction_id) {
		this.initial_faction_id = initial_faction_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Region [region_id=" + region_id + ", zone_id=" + zone_id + ", initial_faction_id=" + initial_faction_id
				+ ", name=" + name + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
