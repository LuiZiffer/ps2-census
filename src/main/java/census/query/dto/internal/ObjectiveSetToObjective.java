package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ObjectiveSetToObjective extends CensusCollectionImpl {

	private String objective_set_id;
	private String objective_group_id;
	
	public ObjectiveSetToObjective() {
		super(Collection.OBJECTIVE_SET_TO_OBJECTIVE);
		// TODO Auto-generated constructor stub
	}

	public String getObjective_set_id() {
		return objective_set_id;
	}

	public void setObjective_set_id(String objective_set_id) {
		this.objective_set_id = objective_set_id;
	}

	public String getObjective_group_id() {
		return objective_group_id;
	}

	public void setObjective_group_id(String objective_group_id) {
		this.objective_group_id = objective_group_id;
	}

	@Override
	public String toString() {
		return "ObjectiveSetToObjective [objective_set_id=" + objective_set_id + ", objective_group_id="
				+ objective_group_id + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}
	
	

}
