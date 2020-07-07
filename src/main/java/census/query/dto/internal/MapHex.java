package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class MapHex extends CensusCollectionImpl {

	private String zone_id;
	private String map_region_id;
	private String x;
	private String y;
	private String hex_type;
	private String type_name;
	
	public MapHex() {
		super(Collection.MAP_HEX);
		// TODO Auto-generated constructor stub
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getMap_region_id() {
		return map_region_id;
	}

	public void setMap_region_id(String map_region_id) {
		this.map_region_id = map_region_id;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getHex_type() {
		return hex_type;
	}

	public void setHex_type(String hex_type) {
		this.hex_type = hex_type;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	@Override
	public String toString() {
		return "MapHex [zone_id=" + zone_id + ", map_region_id=" + map_region_id + ", x=" + x + ", y=" + y
				+ ", hex_type=" + hex_type + ", type_name=" + type_name + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

	
}
