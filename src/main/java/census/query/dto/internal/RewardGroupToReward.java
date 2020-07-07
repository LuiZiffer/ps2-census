package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class RewardGroupToReward extends CensusCollectionImpl {

	private String reward_group_id;
	private String reward_id;
	
	public RewardGroupToReward() {
		super(Collection.REWARD_GROUP_TO_REWARD);
		// TODO Auto-generated constructor stub
	}

	public String getReward_group_id() {
		return reward_group_id;
	}

	public void setReward_group_id(String reward_group_id) {
		this.reward_group_id = reward_group_id;
	}

	public String getReward_id() {
		return reward_id;
	}

	public void setReward_id(String reward_id) {
		this.reward_id = reward_id;
	}

	@Override
	public String toString() {
		return "RewardGroupToReward [reward_group_id=" + reward_group_id + ", reward_id=" + reward_id
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
