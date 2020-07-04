package census.enums;

public enum FireModeType {
    PROJECTILE(0),
    IRON_SIGHT(1),
    MELEE(3),
    TRIGGER_ITEM_ABILITY(8),
    THROWN(12);
	
	private int value;
	
	private FireModeType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
