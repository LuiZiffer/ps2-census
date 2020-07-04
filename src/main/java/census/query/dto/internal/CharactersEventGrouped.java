package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class CharactersEventGrouped extends CensusCollectionImpl {

	private String table_type;
	private String count;
	private String character_id;
	
	public CharactersEventGrouped() {
		super(Collection.CHARACTERS_EVENT_GROUPED);
		
	}

	public String getTable_type() {
		return table_type;
	}

	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	@Override
	public String toString() {
		return "CharactersEventGrouped [table_type=" + table_type + ", count=" + count + ", character_id="
				+ character_id + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
