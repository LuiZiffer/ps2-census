package census.enums;

//On prep phase, relics are set to factionId 4, and spacers are set to 0
public enum DesolationRegion {
	WarpGateN("Northern Command Center","400278","18215", "N_WG"),
	WarpGateSW("Southwest Command Center","400279","18216", "SW_WG"),
	WarpGateSE("Southeast Command Center","400280","18217", "SE_WG"),
	RelicA("Relic Akka","400284","18221", "A"),
	RelicB("Relic Bane","400285","18222", "B"),
	RelicC("Relic Chiron","400287","18224", "C"),
	RelicD("Relic Deimos","400288","18225", "D"),
	RelicE("Relic Etna","400289","18226", "E"),
	RelicF("Relic Feros","400290","18227", "F"),
	RelicG("Relic Gamma","400291","18228", "G"),
	RelicH("Relic Hosk","400292","18229", "H"),
	RelicI("Relic Ibri","400293","18230", "I");
	
	private String regionId;
	private String facilityId;
	private String facilityName;
	private String letter;
	
	
	
	private DesolationRegion(String facilityName, String facilityId, String regionId, String letter) {
		this.facilityName = facilityName;
		this.facilityId = facilityId;
		this.regionId = regionId;
		this.letter = letter;
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
	
	public String getLetter() {
		return letter;
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
	
	public static DesolationRegion findDesolationRegionByFacilityId(String facilityId) {
		for (DesolationRegion region : DesolationRegion.values()) {
			if (region.getFacilityId().equals(facilityId)) {
				return region;
			}
		}
		return null;
	}
	
	public static DesolationRegion findDesolationRegionByRegionId(String regionId) {
		for (DesolationRegion region : DesolationRegion.values()) {
			if (region.getRegionId().equals(regionId)) {
				return region;
			}
		}
		return null;
	}
}
