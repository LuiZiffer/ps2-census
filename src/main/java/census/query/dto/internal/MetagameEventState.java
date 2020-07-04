package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class MetagameEventState extends CensusCollectionImpl {

	private String metagame_event_state_id;
	private String name;
	
	public MetagameEventState() {
		super(Collection.METAGAME_EVENT_STATE);
		// TODO Auto-generated constructor stub
	}

	public String getMetagame_event_state_id() {
		return metagame_event_state_id;
	}

	public void setMetagame_event_state_id(String metagame_event_state_id) {
		this.metagame_event_state_id = metagame_event_state_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MetagameEventState [metagame_event_state_id=" + metagame_event_state_id + ", name=" + name
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	
}
