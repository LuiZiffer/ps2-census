package census.query.dto.util;


public class StatsObject {
	private String stat_history;
	private String stat;
	private String stat_by_faction;
	private String weapon_stat;
	private String weapon_stat_by_faction;
	public String getStat_history() {
		return stat_history;
	}
	public void setStat_history(String stat_history) {
		this.stat_history = stat_history;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getStat_by_faction() {
		return stat_by_faction;
	}
	public void setStat_by_faction(String stat_by_faction) {
		this.stat_by_faction = stat_by_faction;
	}
	public String getWeapon_stat() {
		return weapon_stat;
	}
	public void setWeapon_stat(String weapon_stat) {
		this.weapon_stat = weapon_stat;
	}
	public String getWeapon_stat_by_faction() {
		return weapon_stat_by_faction;
	}
	public void setWeapon_stat_by_faction(String weapon_stat_by_faction) {
		this.weapon_stat_by_faction = weapon_stat_by_faction;
	}
	@Override
	public String toString() {
		return "StatsObject [stat_history=" + stat_history + ", stat=" + stat + ", stat_by_faction=" + stat_by_faction
				+ ", weapon_stat=" + weapon_stat + ", weapon_stat_by_faction=" + weapon_stat_by_faction + "]";
	}
	
}
