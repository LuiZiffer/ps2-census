package census.enums;

public enum TargetType {
    SELF(1),
    ANY(2),
    ENEMY(3),
    ALLY(4);
	
	private int value;
	
	private TargetType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
