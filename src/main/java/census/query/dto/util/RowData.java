package census.query.dto.util;


public class RowData {
	private String regionId;
	private String factionId;
	
	public RowData() {}
	public RowData(String regionId, String factionId) {
		this.regionId = regionId;
		this.factionId = factionId;
	}
	
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getFactionId() {
		return factionId;
	}
	public void setFactionId(String factionId) {
		this.factionId = factionId;
	}
	@Override
	public String toString() {
		return "RowData [RegionId=" + regionId + ", FactionId=" + factionId + "]";
	}
	
	
}
