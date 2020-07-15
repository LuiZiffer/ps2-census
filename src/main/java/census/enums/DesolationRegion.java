package census.enums;

//On prep phase, relics are set to factionId 4, and spacers are set to 0
public enum DesolationRegion {
	WarpGateN("Northern Warpgate","400278","18215"),
	WarpGateSW("South Western Warpgate","400279","18216"),
	WarpGateSE("South Eastern Warpgate","400280","18217"),
	RelicA("Relic A","400284","18221"),
	RelicB("Relic B","400285","18222"),
	RelicC("Relic C","400287","18224"),
	RelicD("Relic D","400288","18225"),
	RelicE("Relic E","400289","18226"),
	RelicF("Relic F","400290","18227"),
	RelicG("Relic G","400291","18228"),
	RelicH("Relic H","400292","18229"),
	RelicI("Relic I","400293","18230");
	
	private String regionId;
	private String facilityId;
	private String facilityName;
	
	private DesolationRegion(String facilityName, String facilityId, String regionId) {
		this.facilityName = facilityName;
		this.facilityId = facilityId;
		this.regionId = regionId;
	}

	public String getRegionId() {
		return regionId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}
	
	public static String getNameByFacility(String facilityId) {
		for (DesolationRegion c : DesolationRegion.values()) {
			if (c.getFacilityId().equals(facilityId)) {
				return c.getFacilityName();
			}
		}
		return null;
	}
	
	public static String getNameByRegion(String regionId) {
		for (DesolationRegion c : DesolationRegion.values()) {
			if (c.getRegionId().equals(regionId)) {
				return c.getFacilityName();
			}
		}
		return null;
	}
	
	public static DesolationRegion findDesolationRegion(String name) {
		for (DesolationRegion region : DesolationRegion.values()) {
			if (region.getFacilityName().equalsIgnoreCase(name)) {
				return region;
			}
		}
		return null;
	}
	
}
