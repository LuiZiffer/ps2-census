package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class MapRegion extends CensusCollectionImpl {

	private String map_region_id;
	private String zone_id;
	private String facility_id;
	private String facility_name;
	private String facility_type_id;
	private String facility_type;
	private String location_x;
	private String location_y;
	private String location_z;
	private String reward_amount;
	private String reward_currency_id;
	
	public MapRegion() {
		super(Collection.MAP_REGION);
		// TODO Auto-generated constructor stub
	}

	public String getMap_region_id() {
		return map_region_id;
	}

	public void setMap_region_id(String map_region_id) {
		this.map_region_id = map_region_id;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public String getFacility_type_id() {
		return facility_type_id;
	}

	public void setFacility_type_id(String facility_type_id) {
		this.facility_type_id = facility_type_id;
	}

	public String getFacility_type() {
		return facility_type;
	}

	public void setFacility_type(String facility_type) {
		this.facility_type = facility_type;
	}

	public String getLocation_x() {
		return location_x;
	}

	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}

	public String getLocation_y() {
		return location_y;
	}

	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}

	public String getLocation_z() {
		return location_z;
	}

	public void setLocation_z(String location_z) {
		this.location_z = location_z;
	}

	public String getReward_amount() {
		return reward_amount;
	}

	public void setReward_amount(String reward_amount) {
		this.reward_amount = reward_amount;
	}

	public String getReward_currency_id() {
		return reward_currency_id;
	}

	public void setReward_currency_id(String reward_currency_id) {
		this.reward_currency_id = reward_currency_id;
	}

	@Override
	public String toString() {
		return "MapRegion [map_region_id=" + map_region_id + ", zone_id=" + zone_id + ", facility_id=" + facility_id
				+ ", facility_name=" + facility_name + ", facility_type_id=" + facility_type_id + ", facility_type="
				+ facility_type + ", location_x=" + location_x + ", location_y=" + location_y + ", location_z="
				+ location_z + ", reward_amount=" + reward_amount + ", reward_currency_id=" + reward_currency_id
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}
	

}
