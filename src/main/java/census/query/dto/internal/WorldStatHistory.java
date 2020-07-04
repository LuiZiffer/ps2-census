package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.DayObject;
import census.query.dto.util.MonthObject;
import census.query.dto.util.WeekObject;

public class WorldStatHistory extends CensusCollectionImpl {

	private String world_id;
	private String stat_name;
	private String type;
	private String tracker_name;
	private String faction;
	private String all_time;
	private DayObject day;
	private MonthObject month;
	private WeekObject week;
	private String last_save;
	private String last_save_date;
	
	public WorldStatHistory() {
		super(Collection.WORLD_STAT_HISTORY);
		// TODO Auto-generated constructor stub
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	public String getStat_name() {
		return stat_name;
	}

	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTracker_name() {
		return tracker_name;
	}

	public void setTracker_name(String tracker_name) {
		this.tracker_name = tracker_name;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getAll_time() {
		return all_time;
	}

	public void setAll_time(String all_time) {
		this.all_time = all_time;
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
		return "WorldStatHistory [world_id=" + world_id + ", stat_name=" + stat_name + ", type=" + type
				+ ", tracker_name=" + tracker_name + ", faction=" + faction + ", all_time=" + all_time + ", day=" + day
				+ ", month=" + month + ", week=" + week + ", last_save=" + last_save + ", last_save_date="
				+ last_save_date + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
