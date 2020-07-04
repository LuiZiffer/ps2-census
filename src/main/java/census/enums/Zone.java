package census.enums;

public enum Zone {
	INDAR(2, "Indar"),
	HOSSIN(4, "Hossin"),
	AMERISH(6, "Amerish"),
	ESAMIR(8, "Esamir"),
	VR_NC(96, "VR(NC)"),
	VR_TR(97, "VR(TR)"),
	VR_VS(98, "VR(VS)"),
	KOLTYR(-1, "Koltyr"),
	DESOLATION(-1, "Desolation");
	
	private int id;
	private String name;
	
	private Zone(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getZoneId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Zone findZone(int zone_id) {
		for (Zone zone : Zone.values()) {
			if (zone.getZoneId() == zone_id) {
				return zone;
			}
		}
		return null;
	}
	
	public Zone findZone(String name) {
		for (Zone zone : Zone.values()) {
			if (zone.getName().equals(name)) {
				return zone;
			}
		}
		return null;
	}
	/*
	public static boolean isDesolation(String worldId, String zoneId) {
		boolean tmp = false;
		if (Integer.parseInt(zoneId) > 100) {
			try {
				tmp = new PS2CensusWrapper().getRegionCount(worldId, zoneId) == 27;
			} catch (ServiceUnavailableException | IOException | PS2CensusBadParametersException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return tmp;
	}
	
	public static boolean isKoltyr(String worldId, String zoneId) {
		boolean tmp = false;
		try {
			tmp = new PS2CensusWrapper().getRegionCount(worldId, zoneId) == 9;
		} catch (ServiceUnavailableException | IOException | PS2CensusBadParametersException e) {
			logger.error(e.getMessage(), e);
		}
		return tmp;
	}*/
}
