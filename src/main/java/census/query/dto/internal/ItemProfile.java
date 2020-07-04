package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class ItemProfile extends CensusCollectionImpl {

	private String item_id;
	private String profile_id;
	
	public ItemProfile() {
		super(Collection.ITEM_PROFILE);
		// TODO Auto-generated constructor stub
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	@Override
	public String toString() {
		return "ItemProfile [item_id=" + item_id + ", profile_id=" + profile_id + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
