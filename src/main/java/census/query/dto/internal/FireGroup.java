package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class FireGroup extends CensusCollectionImpl {

	private String fire_group_id;
	
	public FireGroup() {
		super(Collection.FIRE_GROUP);
		// TODO Auto-generated constructor stub
	}

	public String getFire_group_id() {
		return fire_group_id;
	}

	public void setFire_group_id(String fire_group_id) {
		this.fire_group_id = fire_group_id;
	}

	@Override
	public String toString() {
		return "FireGroup [fire_group_id=" + fire_group_id + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

}
