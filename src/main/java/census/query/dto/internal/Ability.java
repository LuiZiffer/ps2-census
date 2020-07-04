package census.query.dto.internal;

import java.util.ArrayList;
import java.util.List;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class Ability extends CensusCollectionImpl {

	private String ability_id;
	private String ability_type_id;
	
	public Ability() {
		super(Collection.ABILITY);
		
	}

	public String getAbility_id() {
		return ability_id;
	}

	public void setAbility_id(String ability_id) {
		this.ability_id = ability_id;
	}

	public String getAbility_type_id() {
		return ability_type_id;
	}

	public void setAbility_type_id(String ability_type_id) {
		this.ability_type_id = ability_type_id;
	}

	@Override
	public String toString() {
		return "Ability [ability_id=" + ability_id + ", ability_type_id=" + ability_type_id + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

	

}
