package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class WeaponDatasheet extends CensusCollectionImpl {

	private String item_id;
	private String damage;
	private String damage_min;
	private String damage_max;
	private String fire_cone;
	private String fire_cone_min;
	private String fire_cone_max;
	private String fire_rate_ms;
	private String fire_rate_ms_min;
	private String fire_rate_mx_max;
	private String reload_ms;
	private String reload_ms_min;
	private String reload_ms_max;
	private String clip_size;
	private String capacity;
	private LanguageObject range;
	private String show_clip_size;
	private String show_fire_modes;
	private String show_range;
	
	public WeaponDatasheet() {
		super(Collection.WEAPON_DATASHEET);
		// TODO Auto-generated constructor stub
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getDamage_min() {
		return damage_min;
	}

	public void setDamage_min(String damage_min) {
		this.damage_min = damage_min;
	}

	public String getDamage_max() {
		return damage_max;
	}

	public void setDamage_max(String damage_max) {
		this.damage_max = damage_max;
	}

	public String getFire_cone() {
		return fire_cone;
	}

	public void setFire_cone(String fire_cone) {
		this.fire_cone = fire_cone;
	}

	public String getFire_cone_min() {
		return fire_cone_min;
	}

	public void setFire_cone_min(String fire_cone_min) {
		this.fire_cone_min = fire_cone_min;
	}

	public String getFire_cone_max() {
		return fire_cone_max;
	}

	public void setFire_cone_max(String fire_cone_max) {
		this.fire_cone_max = fire_cone_max;
	}

	public String getFire_rate_ms() {
		return fire_rate_ms;
	}

	public void setFire_rate_ms(String fire_rate_ms) {
		this.fire_rate_ms = fire_rate_ms;
	}

	public String getFire_rate_ms_min() {
		return fire_rate_ms_min;
	}

	public void setFire_rate_ms_min(String fire_rate_ms_min) {
		this.fire_rate_ms_min = fire_rate_ms_min;
	}

	public String getFire_rate_mx_max() {
		return fire_rate_mx_max;
	}

	public void setFire_rate_mx_max(String fire_rate_mx_max) {
		this.fire_rate_mx_max = fire_rate_mx_max;
	}

	public String getReload_ms() {
		return reload_ms;
	}

	public void setReload_ms(String reload_ms) {
		this.reload_ms = reload_ms;
	}

	public String getReload_ms_min() {
		return reload_ms_min;
	}

	public void setReload_ms_min(String reload_ms_min) {
		this.reload_ms_min = reload_ms_min;
	}

	public String getReload_ms_max() {
		return reload_ms_max;
	}

	public void setReload_ms_max(String reload_ms_max) {
		this.reload_ms_max = reload_ms_max;
	}

	public String getClip_size() {
		return clip_size;
	}

	public void setClip_size(String clip_size) {
		this.clip_size = clip_size;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public LanguageObject getRange() {
		return range;
	}

	public void setRange(LanguageObject range) {
		this.range = range;
	}

	public String getShow_clip_size() {
		return show_clip_size;
	}

	public void setShow_clip_size(String show_clip_size) {
		this.show_clip_size = show_clip_size;
	}

	public String getShow_fire_modes() {
		return show_fire_modes;
	}

	public void setShow_fire_modes(String show_fire_modes) {
		this.show_fire_modes = show_fire_modes;
	}

	public String getShow_range() {
		return show_range;
	}

	public void setShow_range(String show_range) {
		this.show_range = show_range;
	}

	@Override
	public String toString() {
		return "WeaponDatasheet [item_id=" + item_id + ", damage=" + damage + ", damage_min=" + damage_min
				+ ", damage_max=" + damage_max + ", fire_cone=" + fire_cone + ", fire_cone_min=" + fire_cone_min
				+ ", fire_cone_max=" + fire_cone_max + ", fire_rate_ms=" + fire_rate_ms + ", fire_rate_ms_min="
				+ fire_rate_ms_min + ", fire_rate_mx_max=" + fire_rate_mx_max + ", reload_ms=" + reload_ms
				+ ", reload_ms_min=" + reload_ms_min + ", reload_ms_max=" + reload_ms_max + ", clip_size=" + clip_size
				+ ", capacity=" + capacity + ", range=" + range + ", show_clip_size=" + show_clip_size
				+ ", show_fire_modes=" + show_fire_modes + ", show_range=" + show_range + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}


}
