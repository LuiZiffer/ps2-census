package census.enums;

public enum MetagameEventState {
    STARTED(135),
    RESTARTED(136),
    CANCELED(137),
    ENDED(138),
    XP_BONUS_CHANGED(139);
	
	private int value;
	
	private MetagameEventState(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
