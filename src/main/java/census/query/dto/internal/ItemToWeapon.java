package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ItemToWeapon extends CensusCollectionImpl {

	private String item_id;
	private String weapon_id;
	
	public ItemToWeapon() {
		super(Collection.ITEM_TO_WEAPON);
		// TODO Auto-generated constructor stub
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getWeapon_id() {
		return weapon_id;
	}

	public void setWeapon_id(String weapon_id) {
		this.weapon_id = weapon_id;
	}

	@Override
	public String toString() {
		return "ItemToWeapon [item_id=" + item_id + ", weapon_id=" + weapon_id + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
