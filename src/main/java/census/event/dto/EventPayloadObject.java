package census.event.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import census.event.dto.characterlevel.AchievementEarned;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class EventPayloadObject {
	
	private String event_name;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	
	public EventPayloadObject(String event_name) {
		this.event_name = event_name;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	
	public static final Class<?> retrieveClass(String eventName) {
		//TODO
		switch(eventName) {
			case "AchievementEarned":
				return AchievementEarned.class;
			
			default:
				return null;
		}
	}
}
