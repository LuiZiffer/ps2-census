package census.anatomy.event;

public enum EventStreamWorld {
    JAEGER("19"),
    EMERALD("17"),
    CONNERY("1"),
    MILLER("10"),
    COBALT("13"),
    SOLTECH("40"),
    BRIGGS("25"),
    GENUDINE("1000"),
    CERES("2000"),
    ALL("all");
	
	private String value;
	
	private EventStreamWorld(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
