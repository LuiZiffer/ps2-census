package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class FireMode extends CensusCollectionImpl {

	private String fire_mode_id;
	private String item_id;
	private String type;
	private LanguageObject description;
	private String player_state_group_id;
	private String cof_recoil;
	private String reload_time_ms;
	private String pellets_per_shot;
	private String pellet_spread;
	private String default_zoom;
	private String speed;
	private String projectile_description;
	private String damage_type;
	private String damage;
	private String damage_target_type;
	private String damage_resist_type;
	
	public FireMode() {
		super(Collection.FIRE_MODE);
		// TODO Auto-generated constructor stub
	}

	public String getFire_mode_id() {
		return fire_mode_id;
	}

	public void setFire_mode_id(String fire_mode_id) {
		this.fire_mode_id = fire_mode_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LanguageObject getDescription() {
		return description;
	}

	public void setDescription(LanguageObject description) {
		this.description = description;
	}

	public String getPlayer_state_group_id() {
		return player_state_group_id;
	}

	public void setPlayer_state_group_id(String player_state_group_id) {
		this.player_state_group_id = player_state_group_id;
	}

	public String getCof_recoil() {
		return cof_recoil;
	}

	public void setCof_recoil(String cof_recoil) {
		this.cof_recoil = cof_recoil;
	}

	public String getReload_time_ms() {
		return reload_time_ms;
	}

	public void setReload_time_ms(String reload_time_ms) {
		this.reload_time_ms = reload_time_ms;
	}

	public String getPellets_per_shot() {
		return pellets_per_shot;
	}

	public void setPellets_per_shot(String pellets_per_shot) {
		this.pellets_per_shot = pellets_per_shot;
	}

	public String getPellet_spread() {
		return pellet_spread;
	}

	public void setPellet_spread(String pellet_spread) {
		this.pellet_spread = pellet_spread;
	}

	public String getDefault_zoom() {
		return default_zoom;
	}

	public void setDefault_zoom(String default_zoom) {
		this.default_zoom = default_zoom;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getProjectile_description() {
		return projectile_description;
	}

	public void setProjectile_description(String projectile_description) {
		this.projectile_description = projectile_description;
	}

	public String getDamage_type() {
		return damage_type;
	}

	public void setDamage_type(String damage_type) {
		this.damage_type = damage_type;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getDamage_target_type() {
		return damage_target_type;
	}

	public void setDamage_target_type(String damage_target_type) {
		this.damage_target_type = damage_target_type;
	}

	public String getDamage_resist_type() {
		return damage_resist_type;
	}

	public void setDamage_resist_type(String damage_resist_type) {
		this.damage_resist_type = damage_resist_type;
	}

	@Override
	public String toString() {
		return "FireMode [fire_mode_id=" + fire_mode_id + ", item_id=" + item_id + ", type=" + type + ", description="
				+ description + ", player_state_group_id=" + player_state_group_id + ", cof_recoil=" + cof_recoil
				+ ", reload_time_ms=" + reload_time_ms + ", pellets_per_shot=" + pellets_per_shot + ", pellet_spread="
				+ pellet_spread + ", default_zoom=" + default_zoom + ", speed=" + speed + ", projectile_description="
				+ projectile_description + ", damage_type=" + damage_type + ", damage=" + damage
				+ ", damage_target_type=" + damage_target_type + ", damage_resist_type=" + damage_resist_type
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}
	
	
}
