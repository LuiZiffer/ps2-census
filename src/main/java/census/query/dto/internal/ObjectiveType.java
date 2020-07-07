package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ObjectiveType extends CensusCollectionImpl {

	private String objective_type_id;
	private String description;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	
	public ObjectiveType() {
		super(Collection.OBJECTIVE_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getObjective_type_id() {
		return objective_type_id;
	}

	public void setObjective_type_id(String objective_type_id) {
		this.objective_type_id = objective_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	@Override
	public String toString() {
		return "ObjectiveType [objective_type_id=" + objective_type_id + ", description=" + description + ", param1="
				+ param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4=" + param4 + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}
	
	

}
