package census.anatomy.event;

public enum EventEnvironment {
	PS2("ps2"),
	PS2PS4US("ps2ps4us"),
	PS2PS4EU("ps2ps4eu");
	
	private String value;
	
	private EventEnvironment(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
