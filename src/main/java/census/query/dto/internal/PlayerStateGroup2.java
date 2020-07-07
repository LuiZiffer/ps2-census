package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class PlayerStateGroup2 extends CensusCollectionImpl {

	private String player_state_group_id;
	private String player_state_id;
	private String can_iron_sight;
	private String cof_grow_rate;
	private String cof_max;
	private String cof_min;
	private String cof_recovery_delay_ms;
	private String cof_recovery_rate;
	private String cof_shots_before_penalty;
	private String cof_recovery_delay_threshold;
	private String cof_turn_penalty;
	
	public PlayerStateGroup2() {
		super(Collection.PLAYER_STATE_GROUP_2);
		// TODO Auto-generated constructor stub
	}

	public String getPlayer_state_group_id() {
		return player_state_group_id;
	}

	public void setPlayer_state_group_id(String player_state_group_id) {
		this.player_state_group_id = player_state_group_id;
	}

	public String getPlayer_state_id() {
		return player_state_id;
	}

	public void setPlayer_state_id(String player_state_id) {
		this.player_state_id = player_state_id;
	}

	public String getCan_iron_sight() {
		return can_iron_sight;
	}

	public void setCan_iron_sight(String can_iron_sight) {
		this.can_iron_sight = can_iron_sight;
	}

	public String getCof_grow_rate() {
		return cof_grow_rate;
	}

	public void setCof_grow_rate(String cof_grow_rate) {
		this.cof_grow_rate = cof_grow_rate;
	}

	public String getCof_max() {
		return cof_max;
	}

	public void setCof_max(String cof_max) {
		this.cof_max = cof_max;
	}

	public String getCof_min() {
		return cof_min;
	}

	public void setCof_min(String cof_min) {
		this.cof_min = cof_min;
	}

	public String getCof_recovery_delay_ms() {
		return cof_recovery_delay_ms;
	}

	public void setCof_recovery_delay_ms(String cof_recovery_delay_ms) {
		this.cof_recovery_delay_ms = cof_recovery_delay_ms;
	}

	public String getCof_recovery_rate() {
		return cof_recovery_rate;
	}

	public void setCof_recovery_rate(String cof_recovery_rate) {
		this.cof_recovery_rate = cof_recovery_rate;
	}

	public String getCof_shots_before_penalty() {
		return cof_shots_before_penalty;
	}

	public void setCof_shots_before_penalty(String cof_shots_before_penalty) {
		this.cof_shots_before_penalty = cof_shots_before_penalty;
	}

	public String getCof_recovery_delay_threshold() {
		return cof_recovery_delay_threshold;
	}

	public void setCof_recovery_delay_threshold(String cof_recovery_delay_threshold) {
		this.cof_recovery_delay_threshold = cof_recovery_delay_threshold;
	}

	public String getCof_turn_penalty() {
		return cof_turn_penalty;
	}

	public void setCof_turn_penalty(String cof_turn_penalty) {
		this.cof_turn_penalty = cof_turn_penalty;
	}

	@Override
	public String toString() {
		return "PlayerStateGroup2 [player_state_group_id=" + player_state_group_id + ", player_state_id="
				+ player_state_id + ", can_iron_sight=" + can_iron_sight + ", cof_grow_rate=" + cof_grow_rate
				+ ", cof_max=" + cof_max + ", cof_min=" + cof_min + ", cof_recovery_delay_ms=" + cof_recovery_delay_ms
				+ ", cof_recovery_rate=" + cof_recovery_rate + ", cof_shots_before_penalty=" + cof_shots_before_penalty
				+ ", cof_recovery_delay_threshold=" + cof_recovery_delay_threshold + ", cof_turn_penalty="
				+ cof_turn_penalty + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
