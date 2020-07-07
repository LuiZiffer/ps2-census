package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class RewardType extends CensusCollectionImpl {

	private String reward_type_id;
	private String description;
	private String count_min;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	
	public RewardType() {
		super(Collection.REWARD_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getReward_type_id() {
		return reward_type_id;
	}

	public void setReward_type_id(String reward_type_id) {
		this.reward_type_id = reward_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCount_min() {
		return count_min;
	}

	public void setCount_min(String count_min) {
		this.count_min = count_min;
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
		return "RewardType [reward_type_id=" + reward_type_id + ", description=" + description + ", count_min="
				+ count_min + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4=" + param4
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
