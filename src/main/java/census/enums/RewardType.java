package census.enums;

public enum RewardType {
	ITEM(1),
    XP(3);
	
	private int value;
	
	private RewardType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
