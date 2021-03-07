package census.event.dto;

public class MetagameEvent extends EventPayloadObject {

	private String experience_bonus;
	private String faction_nc;
	private String faction_tr;
	private String faction_vs;
	
	private String metagame_event_id;
	private String metagame_event_state;
	private String metagame_event_state_name;
	
	private String timestamp;
	private String world_id;
	private String instance_id;
	private String zone_id;
	
	
	public MetagameEvent() {
		super("MetagameEvent");
	}


	public String getExperience_bonus() {
		return experience_bonus;
	}


	public void setExperience_bonus(String experience_bonus) {
		this.experience_bonus = experience_bonus;
	}


	public String getFaction_nc() {
		return faction_nc;
	}


	public void setFaction_nc(String faction_nc) {
		this.faction_nc = faction_nc;
	}


	public String getFaction_tr() {
		return faction_tr;
	}


	public void setFaction_tr(String faction_tr) {
		this.faction_tr = faction_tr;
	}


	public String getFaction_vs() {
		return faction_vs;
	}


	public void setFaction_vs(String faction_vs) {
		this.faction_vs = faction_vs;
	}


	public String getMetagame_event_id() {
		return metagame_event_id;
	}


	public void setMetagame_event_id(String metagame_event_id) {
		this.metagame_event_id = metagame_event_id;
	}


	public String getMetagame_event_state() {
		return metagame_event_state;
	}


	public void setMetagame_event_state(String metagame_event_state) {
		this.metagame_event_state = metagame_event_state;
	}


	public String getMetagame_event_state_name() {
		return metagame_event_state_name;
	}


	public void setMetagame_event_state_name(String metagame_event_state_name) {
		this.metagame_event_state_name = metagame_event_state_name;
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


	public String getInstance_id() {
		return instance_id;
	}

	
	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}


	@Override
	public String toString() {
		return "MetagameEvent [experience_bonus=" + experience_bonus + ", faction_nc=" + faction_nc + ", faction_tr="
				+ faction_tr + ", faction_vs=" + faction_vs + ", metagame_event_id=" + metagame_event_id
				+ ", metagame_event_state=" + metagame_event_state + ", metagame_event_state_name="
				+ metagame_event_state_name + ", timestamp=" + timestamp + ", world_id=" + world_id + ", instance_id="
				+ instance_id + ", zone_id=" + zone_id + "]";
	}


	public String getZone_id() {
		return zone_id;
	}


	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	
}
