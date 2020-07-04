package census.enums;

public enum PlayerState {
    STANDING(0),
    CROUCHING(1),
    RUNNING(2),
    SPRINTING(3),
    FALLING_LONG(4),
    CROUCH_WALKING(5),
    JUMPING(6),
    FALLING_SHORT(7);
	
	private int value;
	
	private PlayerState(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
