package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersWeaponStat extends CensusCollectionImpl {

	private String character_id;
	private String stat_name;
	private String item_id;
	private String vehicle_id;
	private String value;
	private String last_save;
	private String last_save_date;
	
	public CharactersWeaponStat() {
		super(Collection.CHARACTERS_WEAPON_STAT);
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

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		return "CharactersWeaponStat [character_id=" + character_id + ", stat_name=" + stat_name + ", item_id="
				+ item_id + ", vehicle_id=" + vehicle_id + ", value=" + value + ", last_save=" + last_save
				+ ", last_save_date=" + last_save_date + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

	
}
