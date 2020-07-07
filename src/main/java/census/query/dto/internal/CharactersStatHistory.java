package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.DayObject;
import census.query.dto.util.MonthObject;
import census.query.dto.util.WeekObject;

public class CharactersStatHistory extends CensusCollectionImpl {

	private String character_id;
	private String stat_name;
	private String all_time;
	private String one_life_max;
	private DayObject day;
	private MonthObject month;
	private WeekObject week;
	private String last_save;
	private String last_save_date;
	
	public CharactersStatHistory() {
		super(Collection.CHARACTERS_STAT_HISTORY);
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

	public String getAll_time() {
		return all_time;
	}

	public void setAll_time(String all_time) {
		this.all_time = all_time;
	}

	public String getOne_life_max() {
		return one_life_max;
	}

	public void setOne_life_max(String one_life_max) {
		this.one_life_max = one_life_max;
	}

	public DayObject getDay() {
		return day;
	}

	public void setDay(DayObject day) {
		this.day = day;
	}

	public MonthObject getMonth() {
		return month;
	}

	public void setMonth(MonthObject month) {
		this.month = month;
	}

	public WeekObject getWeek() {
		return week;
	}

	public void setWeek(WeekObject week) {
		this.week = week;
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
		return "CharactersStatHistory [character_id=" + character_id + ", stat_name=" + stat_name + ", all_time="
				+ all_time + ", one_life_max=" + one_life_max + ", day=" + day + ", month=" + month + ", week=" + week
				+ ", last_save=" + last_save + ", last_save_date=" + last_save_date + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

	
}
