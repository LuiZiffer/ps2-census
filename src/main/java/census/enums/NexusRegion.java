package census.enums;

//On prep phase, relics are set to factionId 4, and spacers are set to 0
//command center facility ids are probably incorrect
public enum NexusRegion {
	WarpGateNE("Nexus Northeast Warpgate","310560","11560", "NE_WG"),
	WarpGateSW("Nexus Southwest Warpgate","310570","11570", "SW_WG"),
	ArazekSATCOMHub("Arazek SATCOM Hub", "310500", "11500", "A_SAT_HUB"),
	NexusSecureSubstation("Nexus Secure Substation", "310510", "11510", "SEC_SUB"),
	HyrdoponicsCompound("HydroponicsCompound", "310520", "11520", "HYDRO"),
	GraniteheadReactor("The Granitehead Reactor", "310530", "11530", "GRA_RCT"),
	ArgentPass("Argent Pass", "310540", "11540", "ARG_PAS"),
	SlateCanyonHold("Slate Canyon Hold", "310550", "11550", "SLA_CAN"),
	BitterGorgeGarrison("Bitter Gorge Garrison", "310590", "11590", "BIT_GRG"),
	NexusAlpha("Nexus Alpha", "310600", "11600", "ALPHA"),
	NexusOmega("Nexus Omega", "310610", "11610", "OMEGA");

	private String regionId;
	private String facilityId;
	private String facilityName;
	private String letter;



	private NexusRegion(String facilityName, String facilityId, String regionId, String letter) {
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
		for (NexusRegion c : NexusRegion.values()) {
			if (c.getFacilityId().equals(facilityId)) {
				return c.getFacilityName();
			}
		}
		return null;
	}
	
	public static String getNameByRegion(String regionId) {
		for (NexusRegion c : NexusRegion.values()) {
			if (c.getRegionId().equals(regionId)) {
				return c.getFacilityName();
			}
		}
		return null;
	}
	
	public static NexusRegion findNexusRegion(String name) {
		for (NexusRegion region : NexusRegion.values()) {
			if (region.getFacilityName().equalsIgnoreCase(name)) {
				return region;
			}
		}
		return null;
	}
	
	public static NexusRegion findNexusRegionByFacilityId(String facilityId) {
		for (NexusRegion region : NexusRegion.values()) {
			if (region.getFacilityId().equals(facilityId)) {
				return region;
			}
		}
		return null;
	}
	
	public static NexusRegion findNexusRegionByRegionId(String regionId) {
		for (NexusRegion region : NexusRegion.values()) {
			if (region.getRegionId().equals(regionId)) {
				return region;
			}
		}
		return null;
	}
}
