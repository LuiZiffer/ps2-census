package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;
import census.query.dto.util.Name;

public class CharacterName extends CensusCollectionImpl {

	private String character_id;
	private Name name;

	public CharacterName() {
		super(Collection.CHARACTER_NAME);
		
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CharacterName [character_id=" + character_id + ", name=" + name + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}
	
	

}
