package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class ResistType extends CensusCollectionImpl {

	private String resist_type_id;
	private String description;
	
	public ResistType() {
		super(Collection.RESIST_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getResist_type_id() {
		return resist_type_id;
	}

	public void setResist_type_id(String resist_type_id) {
		this.resist_type_id = resist_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResistType [resist_type_id=" + resist_type_id + ", description=" + description + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}


}
