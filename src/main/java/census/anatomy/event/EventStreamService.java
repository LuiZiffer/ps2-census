package census.anatomy.event;

public enum EventStreamService {
	EVENT("event");
	
	private String value;
	
	private EventStreamService(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
