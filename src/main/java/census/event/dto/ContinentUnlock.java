package census.event.dto;

public class ContinentUnlock extends EventPayloadObject {
	
	private String timestamp;
	private String world_id;
	private String zone_id;
	private String triggering_faction;
	private String previous_faction;
	private String vs_population;
	private String nc_population;
	private String tr_population;
	private String metagame_event_id;
	private String event_type;

	public ContinentUnlock() {
		super("ContinentUnlock");
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getTriggering_faction() {
		return triggering_faction;
	}

	public void setTriggering_faction(String triggering_faction) {
		this.triggering_faction = triggering_faction;
	}

	public String getPrevious_faction() {
		return previous_faction;
	}

	public void setPrevious_faction(String previous_faction) {
		this.previous_faction = previous_faction;
	}

	public String getVs_population() {
		return vs_population;
	}

	public void setVs_population(String vs_population) {
		this.vs_population = vs_population;
	}

	public String getNc_population() {
		return nc_population;
	}

	public void setNc_population(String nc_population) {
		this.nc_population = nc_population;
	}

	public String getTr_population() {
		return tr_population;
	}

	public void setTr_population(String tr_population) {
		this.tr_population = tr_population;
	}

	public String getMetagame_event_id() {
		return metagame_event_id;
	}

	public void setMetagame_event_id(String metagame_event_id) {
		this.metagame_event_id = metagame_event_id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	@Override
	public String toString() {
		return "ContinentUnlock [timestamp=" + timestamp + ", world_id=" + world_id + ", zone_id=" + zone_id
				+ ", triggering_faction=" + triggering_faction + ", previous_faction=" + previous_faction
				+ ", vs_population=" + vs_population + ", nc_population=" + nc_population + ", tr_population="
				+ tr_population + ", metagame_event_id=" + metagame_event_id + ", event_type=" + event_type + "]";
	}

}
