package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class CharactersAchievment extends CensusCollectionImpl {

	private String character_id;
	private String achievement_id;
	private String start;
	private String start_date;
	private String finish;
	private String finish_date;
	private String last_save;
	private String last_save_date;
	
	public CharactersAchievment() {
		super(Collection.CHARACTERS_ACHIEVEMENT);
		
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(String finish_date) {
		this.finish_date = finish_date;
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
		return "CharactersAchievment [character_id=" + character_id + ", achievement_id=" + achievement_id + ", start="
				+ start + ", start_date=" + start_date + ", finish=" + finish + ", finish_date=" + finish_date
				+ ", last_save=" + last_save + ", last_save_date=" + last_save_date + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
