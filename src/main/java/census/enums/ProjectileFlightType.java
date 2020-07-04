package census.enums;

public enum ProjectileFlightType {
    BALLISTIC(1),
    TRUE_BALLISTIC(3),
    DYNAMIC(9),
    PROXIMITY_DETONATE(10);
	
	private int value;
	
	private ProjectileFlightType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
