package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class FireGroupToFireMode extends CensusCollectionImpl {

	private String fire_group_id;
	private String fire_mode_id;
	private String fire_mode_index;
	
	public FireGroupToFireMode() {
		super(Collection.FIRE_GROUP_TO_FIRE_MODE);
		// TODO Auto-generated constructor stub
	}

	public String getFire_group_id() {
		return fire_group_id;
	}

	public void setFire_group_id(String fire_group_id) {
		this.fire_group_id = fire_group_id;
	}

	public String getFire_mode_id() {
		return fire_mode_id;
	}

	public void setFire_mode_id(String fire_mode_id) {
		this.fire_mode_id = fire_mode_id;
	}

	public String getFire_mode_index() {
		return fire_mode_index;
	}

	public void setFire_mode_index(String fire_mode_index) {
		this.fire_mode_index = fire_mode_index;
	}

	@Override
	public String toString() {
		return "FireGroupToFireMode [fire_group_id=" + fire_group_id + ", fire_mode_id=" + fire_mode_id
				+ ", fire_mode_index=" + fire_mode_index + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

	
}
