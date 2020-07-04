package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class Objective extends CensusCollectionImpl {

	private String objective_id;
	private String objective_type_id;
	private String objective_group_id;
	private String param1;
	private String param4;
	private String param5;
	private String param8;
	
	public Objective() {
		super(Collection.OBJECTIVE);
		// TODO Auto-generated constructor stub
	}

	public String getObjective_id() {
		return objective_id;
	}

	public void setObjective_id(String objective_id) {
		this.objective_id = objective_id;
	}

	public String getObjective_type_id() {
		return objective_type_id;
	}

	public void setObjective_type_id(String objective_type_id) {
		this.objective_type_id = objective_type_id;
	}

	public String getObjective_group_id() {
		return objective_group_id;
	}

	public void setObjective_group_id(String objective_group_id) {
		this.objective_group_id = objective_group_id;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam8() {
		return param8;
	}

	public void setParam8(String param8) {
		this.param8 = param8;
	}

	@Override
	public String toString() {
		return "Objective [objective_id=" + objective_id + ", objective_type_id=" + objective_type_id
				+ ", objective_group_id=" + objective_group_id + ", param1=" + param1 + ", param4=" + param4
				+ ", param5=" + param5 + ", param8=" + param8 + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

	
}
