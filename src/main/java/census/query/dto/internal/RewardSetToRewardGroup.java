package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class RewardSetToRewardGroup extends CensusCollectionImpl {

	private String reward_set_id;
	private String reward_group_id;
	
	public RewardSetToRewardGroup() {
		super(Collection.REWARD_SET_TO_REWARD_GROUP);
		// TODO Auto-generated constructor stub
	}

	public String getReward_set_id() {
		return reward_set_id;
	}

	public void setReward_set_id(String reward_set_id) {
		this.reward_set_id = reward_set_id;
	}

	public String getReward_group_id() {
		return reward_group_id;
	}

	public void setReward_group_id(String reward_group_id) {
		this.reward_group_id = reward_group_id;
	}

	@Override
	public String toString() {
		return "RewardSetToRewardGroup [reward_set_id=" + reward_set_id + ", reward_group_id=" + reward_group_id
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
