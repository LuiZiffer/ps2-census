package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersSkill extends CensusCollectionImpl {
	
	private String character_id;
	private String skill_id;
	private String last_save;
	private String last_save_date;
	
	public CharactersSkill() {
		super(Collection.CHARACTERS_SKILL);
		// TODO Auto-generated constructor stub
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
	}

	public String getLast_save() {
		return last_save;
	}

	public void setLast_save(String last_save) {
		this.last_save = last_save;
	}

	public String getLast_save_date() {
		return last_save_date;
	}

	public void setLast_save_date(String last_save_date) {
		this.last_save_date = last_save_date;
	}

	@Override
	public String toString() {
		return "CharactersSkill [character_id=" + character_id + ", skill_id=" + skill_id + ", last_save=" + last_save
				+ ", last_save_date=" + last_save_date + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}


}
