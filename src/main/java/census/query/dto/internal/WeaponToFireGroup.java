package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class WeaponToFireGroup extends CensusCollectionImpl {

	private String weapon_id;
	private String fire_group_id;
	private String fire_group_index;
	
	public WeaponToFireGroup() {
		super(Collection.WEAPON_TO_FIRE_GROUP);
		// TODO Auto-generated constructor stub
	}

	public String getWeapon_id() {
		return weapon_id;
	}

	public void setWeapon_id(String weapon_id) {
		this.weapon_id = weapon_id;
	}

	public String getFire_group_id() {
		return fire_group_id;
	}

	public void setFire_group_id(String fire_group_id) {
		this.fire_group_id = fire_group_id;
	}

	public String getFire_group_index() {
		return fire_group_index;
	}

	public void setFire_group_index(String fire_group_index) {
		this.fire_group_index = fire_group_index;
	}

	@Override
	public String toString() {
		return "WeaponToFireGroup [weapon_id=" + weapon_id + ", fire_group_id=" + fire_group_id + ", fire_group_index="
				+ fire_group_index + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
