package census.enums;

public enum FacilityType {
	AMP_STATION(2),
    BIO_LAB(3),
    TECH_PLANT(4),
    LARGE_OUTPOST(5),
    SMALL_OUTPOST(6),
    WARPGATE(7),
    INTERLINK_FACILITY(8),
    CONSTRUCTION_OUTPOST(9),
    RELIC_OUTPOST(10);
	
	private int value;
	
	private FacilityType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
