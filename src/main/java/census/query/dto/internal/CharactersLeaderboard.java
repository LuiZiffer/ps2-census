package census.query.dto.internal;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersLeaderboard extends CensusCollectionImpl {
	
	@JsonIgnore
	private Map<String, Object> properties = new HashMap<>();
	
	public CharactersLeaderboard() {
		super(Collection.CHARACTERS_LEADERBOARD);
		// TODO Auto-generated constructor stub
	}

	@JsonAnyGetter
	public Map<String, Object> getProperties() {
		return properties;
	}

	@JsonAnySetter
	public void setProperties(String key, Object value) {
		this.properties.put(key, value);
	}

	@Override
	public String toString() {
		return "CharactersLeaderboard [properties=" + properties + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}
	
}
