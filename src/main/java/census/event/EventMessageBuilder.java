package census.event;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import census.anatomy.event.CharacterEvent;
import census.anatomy.event.EventStreamAction;
import census.anatomy.event.EventStreamService;
import census.anatomy.event.EventStreamWorld;
import census.anatomy.event.WorldEvent;

public class EventMessageBuilder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8549307758691411957L;
	private final String service = EventStreamService.EVENT.toString();
	private String action;
	
	private List<String> worlds = new ArrayList<>();
	private List<String> characters = new ArrayList<>();
	private List<String> eventNames = new ArrayList<>();
	
	private boolean logicalAndCharactersWithWorlds = false;
	private boolean all = false;
	
	@SuppressWarnings("unused")
	private EventMessageBuilder() {}
	
	public EventMessageBuilder(EventStreamAction action) {
		this.action = action.toString();
	}
	
	public EventMessageBuilder(EventMessageBuilder builder) {
		this.action = builder.getAction();
		this.worlds = new ArrayList<>(builder.getWorlds());
		this.characters = new ArrayList<>(builder.getCharacters());
		this.eventNames = new ArrayList<>(builder.getEventNames());
		this.logicalAndCharactersWithWorlds = builder.isLogicalAndCharactersWithWorlds();
		this.all = builder.isAll();
	}
	
	public EventMessageBuilder worlds(EventStreamWorld...worlds) {
		List<String> tmp = Arrays.asList(worlds).stream().map(m -> m.toString()).collect(Collectors.toList());
		this.worlds.addAll(tmp);
		return this;
	}
	
	public EventMessageBuilder chars(String...characters) {
		this.characters.addAll(Arrays.asList(characters));
		return this;
	}
	
	public EventMessageBuilder events(WorldEvent...events) {
		List<String> tmp = Arrays.asList(events).stream().map(m -> m.toString()).collect(Collectors.toList());
		this.eventNames.addAll(tmp);
		return this;
	}
	
	public EventMessageBuilder events(CharacterEvent...events) {
		List<String> tmp = Arrays.asList(events).stream().map(m -> m.toString()).collect(Collectors.toList());
		this.eventNames.addAll(tmp);
		return this;
	}
	
	public EventMessageBuilder gainExperienceEvents(Integer...ids) {
		List<String> tmp = Arrays.asList(ids).stream()
				.map(id -> CharacterEvent.GAIN_EXPERIENCE.toString() + "_experience_id_" + id.toString())
				.collect(Collectors.toList());
		this.eventNames.addAll(tmp);
		return this;
	}
	
	public EventMessageBuilder logicalAndCharactersWithWorlds(boolean arg) {
		logicalAndCharactersWithWorlds = arg;
		return this;
	}
	
	public EventMessageBuilder all(boolean arg) throws IllegalArgumentException {
		if (!action.equals(EventStreamAction.CLEAR_SUBSCRIBE.toString())) throw new IllegalArgumentException("Wrong EventStreamAction. Only CLEAR_SUBSCRIBE is allowed.");
		all = arg;
		return this;
	}
	
	public JsonNode build() {
		return new ObjectMapper().valueToTree(this);
	}

	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<String> getWorlds() {
		return worlds;
	}

	public void setWorlds(List<String> worlds) {
		this.worlds = worlds;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

	public List<String> getEventNames() {
		return eventNames;
	}

	public void setEventNames(List<String> eventNames) {
		this.eventNames = eventNames;
	}

	public boolean isLogicalAndCharactersWithWorlds() {
		return logicalAndCharactersWithWorlds;
	}

	public void setLogicalAndCharactersWithWorlds(boolean logicalAndCharactersWithWorlds) {
		this.logicalAndCharactersWithWorlds = logicalAndCharactersWithWorlds;
	}

	public boolean isAll() {
		return all;
	}

	public void setAll(boolean all) {
		this.all = all;
	}

	public String getService() {
		return service;
	}
	
	public static EventMessageBuilder parse(JsonNode node) throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(node.toString(), EventMessageBuilder.class);
	}

	@Override
	public String toString() {
		return "EventMessageBuilder [service=" + service + ", action=" + action + ", worlds=" + worlds
				+ ", characters=" + characters + ", eventNames=" + eventNames + ", logicalAndCharactersWithWorlds="
				+ logicalAndCharactersWithWorlds + ", all=" + all + "]";
	}
	
	
}
