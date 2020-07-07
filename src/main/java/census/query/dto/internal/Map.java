package census.query.dto.internal;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class Map extends CensusCollectionImpl {

	@JsonIgnore
	private java.util.Map<String, Object> properties = new HashMap<>();
	
	public Map() {
		super(Collection.MAP);
		// TODO Auto-generated constructor stub
	}
	@JsonAnyGetter
	public java.util.Map<String, Object> getProperties() {
		return properties;
	}

	@JsonAnySetter
	public void setProperties(String key, Object value) {
		this.properties.put(key, value);
	}
	@Override
	public String toString() {
		return "Map [properties=" + properties + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}
	
	
}
