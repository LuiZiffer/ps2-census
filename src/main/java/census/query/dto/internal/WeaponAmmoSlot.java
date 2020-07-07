package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class WeaponAmmoSlot extends CensusCollectionImpl {

	private String weapon_id;
	private String weapon_slot_index;
	private String clip_size;
	private String capacity;
	
	public WeaponAmmoSlot() {
		super(Collection.WEAPON_AMMO_SLOT);
		// TODO Auto-generated constructor stub
	}

	public String getWeapon_id() {
		return weapon_id;
	}

	public void setWeapon_id(String weapon_id) {
		this.weapon_id = weapon_id;
	}

	public String getWeapon_slot_index() {
		return weapon_slot_index;
	}

	public void setWeapon_slot_index(String weapon_slot_index) {
		this.weapon_slot_index = weapon_slot_index;
	}

	public String getClip_size() {
		return clip_size;
	}

	public void setClip_size(String clip_size) {
		this.clip_size = clip_size;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "WeaponAmmoSlot [weapon_id=" + weapon_id + ", weapon_slot_index=" + weapon_slot_index + ", clip_size="
				+ clip_size + ", capacity=" + capacity + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}


}
