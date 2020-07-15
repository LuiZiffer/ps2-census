package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.Regions;

public class Map extends CensusCollectionImpl {
	
	private String zoneId;
	private Regions regions;
	
	public Map() {
		super(Collection.MAP);
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "Map [ZoneId=" + zoneId + ", Regions=" + regions + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

	
	
	
	
}
