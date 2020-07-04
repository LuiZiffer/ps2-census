package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class MetagameEvent extends CensusCollectionImpl {

	private String metagame_event_id;
	private LanguageObject name;
	private LanguageObject description;
	private String type;
	private String experience_bonus;
	
	public MetagameEvent() {
		super(Collection.METAGAME_EVENT);
		// TODO Auto-generated constructor stub
	}

	public String getMetagame_event_id() {
		return metagame_event_id;
	}

	public void setMetagame_event_id(String metagame_event_id) {
		this.metagame_event_id = metagame_event_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	public LanguageObject getDescription() {
		return description;
	}

	public void setDescription(LanguageObject description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExperience_bonus() {
		return experience_bonus;
	}

	public void setExperience_bonus(String experience_bonus) {
		this.experience_bonus = experience_bonus;
	}

	@Override
	public String toString() {
		return "MetagameEvent [metagame_event_id=" + metagame_event_id + ", name=" + name + ", description="
				+ description + ", type=" + type + ", experience_bonus=" + experience_bonus + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
