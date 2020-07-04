package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class WeaponToAttachment extends CensusCollectionImpl {

	private String weapon_group_id;
	private String attachment_id;
	private String item_id;
	
	public WeaponToAttachment() {
		super(Collection.WEAPON_TO_ATTACHMENT);
		// TODO Auto-generated constructor stub
	}

	public String getWeapon_group_id() {
		return weapon_group_id;
	}

	public void setWeapon_group_id(String weapon_group_id) {
		this.weapon_group_id = weapon_group_id;
	}

	public String getAttachment_id() {
		return attachment_id;
	}

	public void setAttachment_id(String attachment_id) {
		this.attachment_id = attachment_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "WeaponToAttachment [weapon_group_id=" + weapon_group_id + ", attachment_id=" + attachment_id
				+ ", item_id=" + item_id + ", nestedCollections=" + nestedCollections + ", collection=" + collection
				+ "]";
	}


}
