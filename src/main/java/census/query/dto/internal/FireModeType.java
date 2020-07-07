package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class FireModeType extends CensusCollectionImpl {

	private String fire_mode_type_id;
	private String description;
	
	public FireModeType() {
		super(Collection.FIRE_MODE_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getFire_mode_type_id() {
		return fire_mode_type_id;
	}

	public void setFire_mode_type_id(String fire_mode_type_id) {
		this.fire_mode_type_id = fire_mode_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FireModeType [fire_mode_type_id=" + fire_mode_type_id + ", description=" + description
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
