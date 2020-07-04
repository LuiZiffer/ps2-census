package census.enums;

public enum ArmorFacing {
	FRONT(0),
    RIGHT(1),
    TOP(2),
    REAR(3),
    LEFT(4),
    BOTTOM(5),
    ALL(6);
	
	private int value;
	
	private ArmorFacing(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
