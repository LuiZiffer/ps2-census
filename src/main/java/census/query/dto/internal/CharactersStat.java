package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersStat extends CensusCollectionImpl {

	private String character_id;
	private String stat_name;
	private String profile_id;
	private String value_forever;
	private String value_monthly;
	private String value_weekly;
	private String value_daily;
	private String value_one_life_max;
	private String last_save;
	private String last_save_date;
	
	public CharactersStat() {
		super(Collection.CHARACTERS_STAT);
		// TODO Auto-generated constructor stub
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getStat_name() {
		return stat_name;
	}

	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getValue_forever() {
		return value_forever;
	}

	public void setValue_forever(String value_forever) {
		this.value_forever = value_forever;
	}

	public String getValue_monthly() {
		return value_monthly;
	}

	public void setValue_monthly(String value_monthly) {
		this.value_monthly = value_monthly;
	}

	public String getValue_weekly() {
		return value_weekly;
	}

	public void setValue_weekly(String value_weekly) {
		this.value_weekly = value_weekly;
	}

	public String getValue_daily() {
		return value_daily;
	}

	public void setValue_daily(String value_daily) {
		this.value_daily = value_daily;
	}

	public String getValue_one_life_max() {
		return value_one_life_max;
	}

	public void setValue_one_life_max(String value_one_life_max) {
		this.value_one_life_max = value_one_life_max;
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
		return "CharactersStat [character_id=" + character_id + ", stat_name=" + stat_name + ", profile_id="
				+ profile_id + ", value_forever=" + value_forever + ", value_monthly=" + value_monthly
				+ ", value_weekly=" + value_weekly + ", value_daily=" + value_daily + ", value_one_life_max="
				+ value_one_life_max + ", last_save=" + last_save + ", last_save_date=" + last_save_date
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	

}
