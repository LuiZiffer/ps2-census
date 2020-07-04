package census.anatomy.event;

public enum WorldEvent {
	ALL("all"),
	
    CONTINENT_LOCK("ContinentLock"),
    CONTINENT_UNLOCK("ContinentUnlock"),
    FACILITY_CONTROL("FacilityControl"),
    METAGAME_EVENT("MetagameEvent");
	
	private String value;
	
	private WorldEvent(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
