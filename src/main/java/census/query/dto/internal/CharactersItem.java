package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersItem extends CensusCollectionImpl {

	private String character_id;
	private String item_id;
	private String stack_count;
	private String account_level;
	
	public CharactersItem() {
		super(Collection.CHARACTERS_ITEM);
		
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getStack_count() {
		return stack_count;
	}

	public void setStack_count(String stack_count) {
		this.stack_count = stack_count;
	}

	@Override
	public String toString() {
		return "CharactersItem [character_id=" + character_id + ", item_id=" + item_id + ", stack_count=" + stack_count
				+ ", account_level=" + account_level + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

	

	
}
