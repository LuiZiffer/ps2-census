package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class AbilityType extends CensusCollectionImpl {
	
	private String ability_type_id;
	
	public AbilityType() {
		super(Collection.ABILITY_TYPE);
		
	}

	public String getAbility_type_id() {
		return ability_type_id;
	}

	public void setAbility_type_id(String ability_type_id) {
		this.ability_type_id = ability_type_id;
	}

	@Override
	public String toString() {
		return "AbilityType [ability_type_id=" + ability_type_id + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

	
	
	
}
