package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersWorld extends CensusCollectionImpl {

	private String character_id;
	private String world_id;
	
	public CharactersWorld() {
		super(Collection.CHARACTERS_WORLD);
		// TODO Auto-generated constructor stub
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	@Override
	public String toString() {
		return "CharactersWorld [character_id=" + character_id + ", world_id=" + world_id + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
