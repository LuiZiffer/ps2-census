package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class Reward extends CensusCollectionImpl {

	private String reward_id;
	private String reward_type_id;
	private String count_min;
	private String count_max;
	private String param1;
	
	public Reward() {
		super(Collection.REWARD);
		// TODO Auto-generated constructor stub
	}

	public String getReward_id() {
		return reward_id;
	}

	public void setReward_id(String reward_id) {
		this.reward_id = reward_id;
	}

	public String getReward_type_id() {
		return reward_type_id;
	}

	public void setReward_type_id(String reward_type_id) {
		this.reward_type_id = reward_type_id;
	}

	public String getCount_min() {
		return count_min;
	}

	public void setCount_min(String count_min) {
		this.count_min = count_min;
	}

	public String getCount_max() {
		return count_max;
	}

	public void setCount_max(String count_max) {
		this.count_max = count_max;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	@Override
	public String toString() {
		return "Reward [reward_id=" + reward_id + ", reward_type_id=" + reward_type_id + ", count_min=" + count_min
				+ ", count_max=" + count_max + ", param1=" + param1 + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
