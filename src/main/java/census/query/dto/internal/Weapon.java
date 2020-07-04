package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class Weapon extends CensusCollectionImpl {

	private String weapon_id;
	private String turn_modifier;
	private String move_modifier;
	private String sprint_recovery_ms;
	private String equip_ms;
	private String unequip_ms;
	private String to_iron_sights_ms;
	private String from_iron_sights_ms;
	private String melee_detect_width;
	private String melee_detect_height;
	
	public Weapon() {
		super(Collection.WEAPON);
		// TODO Auto-generated constructor stub
	}

	public String getWeapon_id() {
		return weapon_id;
	}

	public void setWeapon_id(String weapon_id) {
		this.weapon_id = weapon_id;
	}

	public String getTurn_modifier() {
		return turn_modifier;
	}

	public void setTurn_modifier(String turn_modifier) {
		this.turn_modifier = turn_modifier;
	}

	public String getMove_modifier() {
		return move_modifier;
	}

	public void setMove_modifier(String move_modifier) {
		this.move_modifier = move_modifier;
	}

	public String getSprint_recovery_ms() {
		return sprint_recovery_ms;
	}

	public void setSprint_recovery_ms(String sprint_recovery_ms) {
		this.sprint_recovery_ms = sprint_recovery_ms;
	}

	public String getEquip_ms() {
		return equip_ms;
	}

	public void setEquip_ms(String equip_ms) {
		this.equip_ms = equip_ms;
	}

	public String getUnequip_ms() {
		return unequip_ms;
	}

	public void setUnequip_ms(String unequip_ms) {
		this.unequip_ms = unequip_ms;
	}

	public String getTo_iron_sights_ms() {
		return to_iron_sights_ms;
	}

	public void setTo_iron_sights_ms(String to_iron_sights_ms) {
		this.to_iron_sights_ms = to_iron_sights_ms;
	}

	public String getFrom_iron_sights_ms() {
		return from_iron_sights_ms;
	}

	public void setFrom_iron_sights_ms(String from_iron_sights_ms) {
		this.from_iron_sights_ms = from_iron_sights_ms;
	}

	public String getMelee_detect_width() {
		return melee_detect_width;
	}

	public void setMelee_detect_width(String melee_detect_width) {
		this.melee_detect_width = melee_detect_width;
	}

	public String getMelee_detect_height() {
		return melee_detect_height;
	}

	public void setMelee_detect_height(String melee_detect_height) {
		this.melee_detect_height = melee_detect_height;
	}

	@Override
	public String toString() {
		return "Weapon [weapon_id=" + weapon_id + ", turn_modifier=" + turn_modifier + ", move_modifier="
				+ move_modifier + ", sprint_recovery_ms=" + sprint_recovery_ms + ", equip_ms=" + equip_ms
				+ ", unequip_ms=" + unequip_ms + ", to_iron_sights_ms=" + to_iron_sights_ms + ", from_iron_sights_ms="
				+ from_iron_sights_ms + ", melee_detect_width=" + melee_detect_width + ", melee_detect_height="
				+ melee_detect_height + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	
}
