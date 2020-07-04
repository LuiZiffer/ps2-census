package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class Profile extends CensusCollectionImpl {

	private String profile_id;
	private String profile_type_id;
	private String profile_type_description;
	private String faction_id;
	private LanguageObject name;
	private LanguageObject description;
	private String image_set_id;
	private String image_id;
	private String image_path;
	private String movement_speed;
	private String backpedal_speed_modifier;
	private String sprint_speed_modifier;
	private String strafe_speed_modifier;
	
	public Profile() {
		super(Collection.PROFILE);
		// TODO Auto-generated constructor stub
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getProfile_type_id() {
		return profile_type_id;
	}

	public void setProfile_type_id(String profile_type_id) {
		this.profile_type_id = profile_type_id;
	}

	public String getProfile_type_description() {
		return profile_type_description;
	}

	public void setProfile_type_description(String profile_type_description) {
		this.profile_type_description = profile_type_description;
	}

	public String getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(String faction_id) {
		this.faction_id = faction_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	public LanguageObject getDescription() {
		return description;
	}

	public void setDescription(LanguageObject description) {
		this.description = description;
	}

	public String getImage_set_id() {
		return image_set_id;
	}

	public void setImage_set_id(String image_set_id) {
		this.image_set_id = image_set_id;
	}

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getMovement_speed() {
		return movement_speed;
	}

	public void setMovement_speed(String movement_speed) {
		this.movement_speed = movement_speed;
	}

	public String getBackpedal_speed_modifier() {
		return backpedal_speed_modifier;
	}

	public void setBackpedal_speed_modifier(String backpedal_speed_modifier) {
		this.backpedal_speed_modifier = backpedal_speed_modifier;
	}

	public String getSprint_speed_modifier() {
		return sprint_speed_modifier;
	}

	public void setSprint_speed_modifier(String sprint_speed_modifier) {
		this.sprint_speed_modifier = sprint_speed_modifier;
	}

	public String getStrafe_speed_modifier() {
		return strafe_speed_modifier;
	}

	public void setStrafe_speed_modifier(String strafe_speed_modifier) {
		this.strafe_speed_modifier = strafe_speed_modifier;
	}

	@Override
	public String toString() {
		return "Profile [profile_id=" + profile_id + ", profile_type_id=" + profile_type_id
				+ ", profile_type_description=" + profile_type_description + ", faction_id=" + faction_id + ", name="
				+ name + ", description=" + description + ", image_set_id=" + image_set_id + ", image_id=" + image_id
				+ ", image_path=" + image_path + ", movement_speed=" + movement_speed + ", backpedal_speed_modifier="
				+ backpedal_speed_modifier + ", sprint_speed_modifier=" + sprint_speed_modifier
				+ ", strafe_speed_modifier=" + strafe_speed_modifier + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
