package census.anatomy.event;

public enum EventStreamAction {
    SUBSCRIBE("subscribe"),
    ECHO("echo"),
    CLEAR_SUBSCRIBE("clearSubscribe"),
    RECENT_CHARACTER_IDS("recentCharacterIds"),
    RECENT_CHARACTER_IDS_COUNT("recentCharacterIdsCount");
	
	private String value;
	
	private EventStreamAction(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
