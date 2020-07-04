package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class SkillCategory extends CensusCollectionImpl {

	private String skill_category_id;
	private String skill_set_id;
	private String skill_set_index;
	private String skill_points;
	private LanguageObject name;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public SkillCategory() {
		super(Collection.SKILL_CATEGORY);
		// TODO Auto-generated constructor stub
	}

	public String getSkill_category_id() {
		return skill_category_id;
	}

	public void setSkill_category_id(String skill_category_id) {
		this.skill_category_id = skill_category_id;
	}

	public String getSkill_set_id() {
		return skill_set_id;
	}

	public void setSkill_set_id(String skill_set_id) {
		this.skill_set_id = skill_set_id;
	}

	public String getSkill_set_index() {
		return skill_set_index;
	}

	public void setSkill_set_index(String skill_set_index) {
		this.skill_set_index = skill_set_index;
	}

	public String getSkill_points() {
		return skill_points;
	}

	public void setSkill_points(String skill_points) {
		this.skill_points = skill_points;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "SkillCategory [skill_category_id=" + skill_category_id + ", skill_set_id=" + skill_set_id
				+ ", skill_set_index=" + skill_set_index + ", skill_points=" + skill_points + ", name=" + name
				+ ", image_set_id=" + image_set_id + ", image_id=" + image_id + ", image_path=" + image_path
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
