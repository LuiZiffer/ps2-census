package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class World extends CensusCollectionImpl {

	private String world_id;
	private String state;
	private LanguageObject name;
	
	public World() {
		super(Collection.WORLD);
		// TODO Auto-generated constructor stub
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "World [world_id=" + world_id + ", state=" + state + ", name=" + name + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}


}
