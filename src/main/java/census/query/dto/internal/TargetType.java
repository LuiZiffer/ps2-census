package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class TargetType extends CensusCollectionImpl {

	private String target_type_id;
	private String description;
	
	public TargetType() {
		super(Collection.TARGET_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getTarget_type_id() {
		return target_type_id;
	}

	public void setTarget_type_id(String target_type_id) {
		this.target_type_id = target_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TargetType [target_type_id=" + target_type_id + ", description=" + description + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
