package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class CharactersStatByFaction extends CensusCollectionImpl {

	private String character_id;
	private String stat_name;
	private String profile_id;
	private String value_forever_vs;
	private String value_forever_nc;
	private String value_forever_tr;
	private String value_monthly_vs;
	private String value_monthly_nc;
	private String value_monthly_tr;
	private String value_weekly_vs;
	private String value_weekly_nc;
	private String value_weekly_tr;
	private String value_daily_vs;
	private String value_daily_nc;
	private String value_daily_tr;
	private String value_one_life_max_vs;
	private String value_one_life_max_nc;
	private String value_one_life_max_tr;
	private String last_save;
	private String last_save_date;
	
	public CharactersStatByFaction() {
		super(Collection.CHARACTERS_STAT_BY_FACTION);
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

	public String getValue_forever_vs() {
		return value_forever_vs;
	}

	public void setValue_forever_vs(String value_forever_vs) {
		this.value_forever_vs = value_forever_vs;
	}

	public String getValue_forever_nc() {
		return value_forever_nc;
	}

	public void setValue_forever_nc(String value_forever_nc) {
		this.value_forever_nc = value_forever_nc;
	}

	public String getValue_forever_tr() {
		return value_forever_tr;
	}

	public void setValue_forever_tr(String value_forever_tr) {
		this.value_forever_tr = value_forever_tr;
	}

	public String getValue_monthly_vs() {
		return value_monthly_vs;
	}

	public void setValue_monthly_vs(String value_monthly_vs) {
		this.value_monthly_vs = value_monthly_vs;
	}

	public String getValue_monthly_nc() {
		return value_monthly_nc;
	}

	public void setValue_monthly_nc(String value_monthly_nc) {
		this.value_monthly_nc = value_monthly_nc;
	}

	public String getValue_monthly_tr() {
		return value_monthly_tr;
	}

	public void setValue_monthly_tr(String value_monthly_tr) {
		this.value_monthly_tr = value_monthly_tr;
	}

	public String getValue_weekly_vs() {
		return value_weekly_vs;
	}

	public void setValue_weekly_vs(String value_weekly_vs) {
		this.value_weekly_vs = value_weekly_vs;
	}

	public String getValue_weekly_nc() {
		return value_weekly_nc;
	}

	public void setValue_weekly_nc(String value_weekly_nc) {
		this.value_weekly_nc = value_weekly_nc;
	}

	public String getValue_weekly_tr() {
		return value_weekly_tr;
	}

	public void setValue_weekly_tr(String value_weekly_tr) {
		this.value_weekly_tr = value_weekly_tr;
	}

	public String getValue_daily_vs() {
		return value_daily_vs;
	}

	public void setValue_daily_vs(String value_daily_vs) {
		this.value_daily_vs = value_daily_vs;
	}

	public String getValue_daily_nc() {
		return value_daily_nc;
	}

	public void setValue_daily_nc(String value_daily_nc) {
		this.value_daily_nc = value_daily_nc;
	}

	public String getValue_daily_tr() {
		return value_daily_tr;
	}

	public void setValue_daily_tr(String value_daily_tr) {
		this.value_daily_tr = value_daily_tr;
	}

	public String getValue_one_life_max_vs() {
		return value_one_life_max_vs;
	}

	public void setValue_one_life_max_vs(String value_one_life_max_vs) {
		this.value_one_life_max_vs = value_one_life_max_vs;
	}

	public String getValue_one_life_max_nc() {
		return value_one_life_max_nc;
	}

	public void setValue_one_life_max_nc(String value_one_life_max_nc) {
		this.value_one_life_max_nc = value_one_life_max_nc;
	}

	public String getValue_one_life_max_tr() {
		return value_one_life_max_tr;
	}

	public void setValue_one_life_max_tr(String value_one_life_max_tr) {
		this.value_one_life_max_tr = value_one_life_max_tr;
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
		return "CharactersStatByFaction [character_id=" + character_id + ", stat_name=" + stat_name + ", profile_id="
				+ profile_id + ", value_forever_vs=" + value_forever_vs + ", value_forever_nc=" + value_forever_nc
				+ ", value_forever_tr=" + value_forever_tr + ", value_monthly_vs=" + value_monthly_vs
				+ ", value_monthly_nc=" + value_monthly_nc + ", value_monthly_tr=" + value_monthly_tr
				+ ", value_weekly_vs=" + value_weekly_vs + ", value_weekly_nc=" + value_weekly_nc + ", value_weekly_tr="
				+ value_weekly_tr + ", value_daily_vs=" + value_daily_vs + ", value_daily_nc=" + value_daily_nc
				+ ", value_daily_tr=" + value_daily_tr + ", value_one_life_max_vs=" + value_one_life_max_vs
				+ ", value_one_life_max_nc=" + value_one_life_max_nc + ", value_one_life_max_tr="
				+ value_one_life_max_tr + ", last_save=" + last_save + ", last_save_date=" + last_save_date
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	

}
