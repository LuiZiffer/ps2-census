package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class FireMode2 extends CensusCollectionImpl {

	private String fire_mode_id;
	private String fire_mode_type_id;
	private String automatic;
	private String grief_immune;
	private String iron_sights;
	private String move_modifier;
	private String sprint_fire;
	private String turn_modifier;
	private String use_in_water;
	private String zoom_default;
	private String cof_override;
	private String cof_pellet_spread;
	private String cof_range;
	private String cof_recoil;
	private String cof_scalar;
	private String cof_scalar_moving;
	private String player_state_group_id;
	private String damage_head_multiplier;
	private String fire_ammo_per_shot;
	private String fire_auto_fire_ms;
	private String fire_burst_count;
	private String fire_charge_up_ms;
	private String fire_delay_ms;
	private String fire_detect_range;
	private String fire_duration_ms;
	private String fire_refire_ms;
	private String fire_pellets_per_shot;
	private String lockon_angle;
	private String recoil_first_shot_modifier;
	private String recoil_increase;
	private String recoil_increase_crouched;
	private String recoil_max_total_magnitude;
	private String recoil_recovery_acceleration;
	private String recoil_recovery_delay_ms;
	private String recoil_recovery_rate;
	private String recoil_shots_at_min_magnitude;
	private String reload_time_ms;
	private LanguageObject description;
	
	public FireMode2() {
		super(Collection.FIRE_MODE_2);
		// TODO Auto-generated constructor stub
	}

	public String getFire_mode_id() {
		return fire_mode_id;
	}

	public void setFire_mode_id(String fire_mode_id) {
		this.fire_mode_id = fire_mode_id;
	}

	public String getFire_mode_type_id() {
		return fire_mode_type_id;
	}

	public void setFire_mode_type_id(String fire_mode_type_id) {
		this.fire_mode_type_id = fire_mode_type_id;
	}

	public String getAutomatic() {
		return automatic;
	}

	public void setAutomatic(String automatic) {
		this.automatic = automatic;
	}

	public String getGrief_immune() {
		return grief_immune;
	}

	public void setGrief_immune(String grief_immune) {
		this.grief_immune = grief_immune;
	}

	public String getIron_sights() {
		return iron_sights;
	}

	public void setIron_sights(String iron_sights) {
		this.iron_sights = iron_sights;
	}

	public String getMove_modifier() {
		return move_modifier;
	}

	public void setMove_modifier(String move_modifier) {
		this.move_modifier = move_modifier;
	}

	public String getSprint_fire() {
		return sprint_fire;
	}

	public void setSprint_fire(String sprint_fire) {
		this.sprint_fire = sprint_fire;
	}

	public String getTurn_modifier() {
		return turn_modifier;
	}

	public void setTurn_modifier(String turn_modifier) {
		this.turn_modifier = turn_modifier;
	}

	public String getUse_in_water() {
		return use_in_water;
	}

	public void setUse_in_water(String use_in_water) {
		this.use_in_water = use_in_water;
	}

	public String getZoom_default() {
		return zoom_default;
	}

	public void setZoom_default(String zoom_default) {
		this.zoom_default = zoom_default;
	}

	public String getCof_override() {
		return cof_override;
	}

	public void setCof_override(String cof_override) {
		this.cof_override = cof_override;
	}

	public String getCof_pellet_spread() {
		return cof_pellet_spread;
	}

	public void setCof_pellet_spread(String cof_pellet_spread) {
		this.cof_pellet_spread = cof_pellet_spread;
	}

	public String getCof_range() {
		return cof_range;
	}

	public void setCof_range(String cof_range) {
		this.cof_range = cof_range;
	}

	public String getCof_recoil() {
		return cof_recoil;
	}

	public void setCof_recoil(String cof_recoil) {
		this.cof_recoil = cof_recoil;
	}

	public String getCof_scalar() {
		return cof_scalar;
	}

	public void setCof_scalar(String cof_scalar) {
		this.cof_scalar = cof_scalar;
	}

	public String getCof_scalar_moving() {
		return cof_scalar_moving;
	}

	public void setCof_scalar_moving(String cof_scalar_moving) {
		this.cof_scalar_moving = cof_scalar_moving;
	}

	public String getPlayer_state_group_id() {
		return player_state_group_id;
	}

	public void setPlayer_state_group_id(String player_state_group_id) {
		this.player_state_group_id = player_state_group_id;
	}

	public String getDamage_head_multiplier() {
		return damage_head_multiplier;
	}

	public void setDamage_head_multiplier(String damage_head_multiplier) {
		this.damage_head_multiplier = damage_head_multiplier;
	}

	public String getFire_ammo_per_shot() {
		return fire_ammo_per_shot;
	}

	public void setFire_ammo_per_shot(String fire_ammo_per_shot) {
		this.fire_ammo_per_shot = fire_ammo_per_shot;
	}

	public String getFire_auto_fire_ms() {
		return fire_auto_fire_ms;
	}

	public void setFire_auto_fire_ms(String fire_auto_fire_ms) {
		this.fire_auto_fire_ms = fire_auto_fire_ms;
	}

	public String getFire_burst_count() {
		return fire_burst_count;
	}

	public void setFire_burst_count(String fire_burst_count) {
		this.fire_burst_count = fire_burst_count;
	}

	public String getFire_charge_up_ms() {
		return fire_charge_up_ms;
	}

	public void setFire_charge_up_ms(String fire_charge_up_ms) {
		this.fire_charge_up_ms = fire_charge_up_ms;
	}

	public String getFire_delay_ms() {
		return fire_delay_ms;
	}

	public void setFire_delay_ms(String fire_delay_ms) {
		this.fire_delay_ms = fire_delay_ms;
	}

	public String getFire_detect_range() {
		return fire_detect_range;
	}

	public void setFire_detect_range(String fire_detect_range) {
		this.fire_detect_range = fire_detect_range;
	}

	public String getFire_duration_ms() {
		return fire_duration_ms;
	}

	public void setFire_duration_ms(String fire_duration_ms) {
		this.fire_duration_ms = fire_duration_ms;
	}

	public String getFire_refire_ms() {
		return fire_refire_ms;
	}

	public void setFire_refire_ms(String fire_refire_ms) {
		this.fire_refire_ms = fire_refire_ms;
	}

	public String getFire_pellets_per_shot() {
		return fire_pellets_per_shot;
	}

	public void setFire_pellets_per_shot(String fire_pellets_per_shot) {
		this.fire_pellets_per_shot = fire_pellets_per_shot;
	}

	public String getLockon_angle() {
		return lockon_angle;
	}

	public void setLockon_angle(String lockon_angle) {
		this.lockon_angle = lockon_angle;
	}

	public String getRecoil_first_shot_modifier() {
		return recoil_first_shot_modifier;
	}

	public void setRecoil_first_shot_modifier(String recoil_first_shot_modifier) {
		this.recoil_first_shot_modifier = recoil_first_shot_modifier;
	}

	public String getRecoil_increase() {
		return recoil_increase;
	}

	public void setRecoil_increase(String recoil_increase) {
		this.recoil_increase = recoil_increase;
	}

	public String getRecoil_increase_crouched() {
		return recoil_increase_crouched;
	}

	public void setRecoil_increase_crouched(String recoil_increase_crouched) {
		this.recoil_increase_crouched = recoil_increase_crouched;
	}

	public String getRecoil_max_total_magnitude() {
		return recoil_max_total_magnitude;
	}

	public void setRecoil_max_total_magnitude(String recoil_max_total_magnitude) {
		this.recoil_max_total_magnitude = recoil_max_total_magnitude;
	}

	public String getRecoil_recovery_acceleration() {
		return recoil_recovery_acceleration;
	}

	public void setRecoil_recovery_acceleration(String recoil_recovery_acceleration) {
		this.recoil_recovery_acceleration = recoil_recovery_acceleration;
	}

	public String getRecoil_recovery_delay_ms() {
		return recoil_recovery_delay_ms;
	}

	public void setRecoil_recovery_delay_ms(String recoil_recovery_delay_ms) {
		this.recoil_recovery_delay_ms = recoil_recovery_delay_ms;
	}

	public String getRecoil_recovery_rate() {
		return recoil_recovery_rate;
	}

	public void setRecoil_recovery_rate(String recoil_recovery_rate) {
		this.recoil_recovery_rate = recoil_recovery_rate;
	}

	public String getRecoil_shots_at_min_magnitude() {
		return recoil_shots_at_min_magnitude;
	}

	public void setRecoil_shots_at_min_magnitude(String recoil_shots_at_min_magnitude) {
		this.recoil_shots_at_min_magnitude = recoil_shots_at_min_magnitude;
	}

	public String getReload_time_ms() {
		return reload_time_ms;
	}

	public void setReload_time_ms(String reload_time_ms) {
		this.reload_time_ms = reload_time_ms;
	}

	public LanguageObject getDescription() {
		return description;
	}

	public void setDescription(LanguageObject description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FireMode2 [fire_mode_id=" + fire_mode_id + ", fire_mode_type_id=" + fire_mode_type_id + ", automatic="
				+ automatic + ", grief_immune=" + grief_immune + ", iron_sights=" + iron_sights + ", move_modifier="
				+ move_modifier + ", sprint_fire=" + sprint_fire + ", turn_modifier=" + turn_modifier
				+ ", use_in_water=" + use_in_water + ", zoom_default=" + zoom_default + ", cof_override=" + cof_override
				+ ", cof_pellet_spread=" + cof_pellet_spread + ", cof_range=" + cof_range + ", cof_recoil=" + cof_recoil
				+ ", cof_scalar=" + cof_scalar + ", cof_scalar_moving=" + cof_scalar_moving + ", player_state_group_id="
				+ player_state_group_id + ", damage_head_multiplier=" + damage_head_multiplier + ", fire_ammo_per_shot="
				+ fire_ammo_per_shot + ", fire_auto_fire_ms=" + fire_auto_fire_ms + ", fire_burst_count="
				+ fire_burst_count + ", fire_charge_up_ms=" + fire_charge_up_ms + ", fire_delay_ms=" + fire_delay_ms
				+ ", fire_detect_range=" + fire_detect_range + ", fire_duration_ms=" + fire_duration_ms
				+ ", fire_refire_ms=" + fire_refire_ms + ", fire_pellets_per_shot=" + fire_pellets_per_shot
				+ ", lockon_angle=" + lockon_angle + ", recoil_first_shot_modifier=" + recoil_first_shot_modifier
				+ ", recoil_increase=" + recoil_increase + ", recoil_increase_crouched=" + recoil_increase_crouched
				+ ", recoil_max_total_magnitude=" + recoil_max_total_magnitude + ", recoil_recovery_acceleration="
				+ recoil_recovery_acceleration + ", recoil_recovery_delay_ms=" + recoil_recovery_delay_ms
				+ ", recoil_recovery_rate=" + recoil_recovery_rate + ", recoil_shots_at_min_magnitude="
				+ recoil_shots_at_min_magnitude + ", reload_time_ms=" + reload_time_ms + ", description=" + description
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}
	
	

}
