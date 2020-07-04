package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class PlayerState extends CensusCollectionImpl {

	private String player_state_id;
	private String description;
	
	public PlayerState() {
		super(Collection.PLAYER_STATE);
		// TODO Auto-generated constructor stub
	}

	public String getPlayer_state_id() {
		return player_state_id;
	}

	public void setPlayer_state_id(String player_state_id) {
		this.player_state_id = player_state_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PlayerState [player_state_id=" + player_state_id + ", description=" + description
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
