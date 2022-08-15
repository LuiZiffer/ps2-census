package census.enums;

public enum Zone {
	INDAR(2, "Indar"),
	HOSSIN(4, "Hossin"),
	AMERISH(6, "Amerish"),
	ESAMIR(8, "Esamir"),
	OSHUR(344, "Oshur"),
	VR_NC(96, "VR(NC)"),
	VR_TR(97, "VR(TR)"),
	VR_VS(98, "VR(VS)"),
	KOLTYR(-1, "Koltyr"),
	DESOLATION(-1, "Desolation"),
	NEXUS(-1, "Nexus");
	
	private int id;
	private String name;
	
	public static final long DESOLATION_DEFINITIONID = 361;
	public static final long KOLTYR_DEFINITIONID = 14;
	public static final long NEXUS_DEFINITIONID = 10;
	
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
	
	public static Zone findZone(int zone_id) {
		for (Zone zone : Zone.values()) {
			if (zone.getZoneId() == zone_id) {
				return zone;
			}
		}
		return null;
	}
	
	public static Zone findZone(String name) {
		for (Zone zone : Zone.values()) {
			if (zone.getName().equals(name)) {
				return zone;
			}
		}
		return null;
	}
	
	public static boolean isDesolation(long zone_id) {
		return (0x0000FFFF & zone_id) == DESOLATION_DEFINITIONID;
	}

	public static boolean isNexus(long zone_id) {return (0x0000FFFF & zone_id) == NEXUS_DEFINITIONID;}
	
	public static boolean isKoltyr(long zone_id) {
		return (0x0000FFFF & zone_id) == KOLTYR_DEFINITIONID;
	}
	
	public static long calcInstanceId(long zone_id) {
		return (0xFFFF0000 & zone_id) >>> 16;
	}
	
	public static long calcZoneId(long instance_id, long definition_id) {
		return (instance_id << 16) & definition_id;
	}
}
