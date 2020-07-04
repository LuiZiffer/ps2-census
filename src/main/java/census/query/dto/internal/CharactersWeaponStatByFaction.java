package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class CharactersWeaponStatByFaction extends CensusCollectionImpl {

	private String character_id;
	private String stat_name;
	private String item_id;
	private String vehicle_id;
	private String value_vs;
	private String value_nc;
	private String value_tr;
	private String last_save;
	private String last_save_date;
	
	public CharactersWeaponStatByFaction() {
		super(Collection.CHARACTERS_WEAPON_STAT_BY_FACTION);
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

	public String getValue_vs() {
		return value_vs;
	}

	public void setValue_vs(String value_vs) {
		this.value_vs = value_vs;
	}

	public String getValue_nc() {
		return value_nc;
	}

	public void setValue_nc(String value_nc) {
		this.value_nc = value_nc;
	}

	public String getValue_tr() {
		return value_tr;
	}

	public void setValue_tr(String value_tr) {
		this.value_tr = value_tr;
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
		return "CharactersWeaponStatByFaction [character_id=" + character_id + ", stat_name=" + stat_name + ", item_id="
				+ item_id + ", vehicle_id=" + vehicle_id + ", value_vs=" + value_vs + ", value_nc=" + value_nc
				+ ", value_tr=" + value_tr + ", last_save=" + last_save + ", last_save_date=" + last_save_date
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}
	
	
}
