package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class PlayerStateGroup extends CensusCollectionImpl {

	private String player_state_group_id;
	private String player_state;
	private String min_cone_of_fire;
	
	public PlayerStateGroup() {
		super(Collection.PLAYER_STATE_GROUP);
		// TODO Auto-generated constructor stub
	}

	public String getPlayer_state_group_id() {
		return player_state_group_id;
	}

	public void setPlayer_state_group_id(String player_state_group_id) {
		this.player_state_group_id = player_state_group_id;
	}

	public String getPlayer_state() {
		return player_state;
	}

	public void setPlayer_state(String player_state) {
		this.player_state = player_state;
	}

	public String getMin_cone_of_fire() {
		return min_cone_of_fire;
	}

	public void setMin_cone_of_fire(String min_cone_of_fire) {
		this.min_cone_of_fire = min_cone_of_fire;
	}

	@Override
	public String toString() {
		return "PlayerStateGroup [player_state_group_id=" + player_state_group_id + ", player_state=" + player_state
				+ ", min_cone_of_fire=" + min_cone_of_fire + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
