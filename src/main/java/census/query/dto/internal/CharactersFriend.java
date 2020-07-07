package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersFriend extends CensusCollectionImpl {

	private String character_id;
	private String name;
	private String friend_list;
	
	public CharactersFriend() {
		super(Collection.CHARACTERS_FRIEND);
		
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFriend_list() {
		return friend_list;
	}

	public void setFriend_list(String friend_list) {
		this.friend_list = friend_list;
	}

	@Override
	public String toString() {
		return "CharactersFriend [character_id=" + character_id + ", name=" + name + ", friend_list=" + friend_list
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
