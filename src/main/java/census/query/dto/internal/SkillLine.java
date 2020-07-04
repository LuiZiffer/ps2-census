package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class SkillLine extends CensusCollectionImpl {

	private String skill_line_id;
	private String skill_points;
	private LanguageObject name;
	private LanguageObject description;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public SkillLine() {
		super(Collection.SKILL_LINE);
		// TODO Auto-generated constructor stub
	}

	public String getSkill_line_id() {
		return skill_line_id;
	}

	public void setSkill_line_id(String skill_line_id) {
		this.skill_line_id = skill_line_id;
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

	@Override
	public String toString() {
		return "SkillLine [skill_line_id=" + skill_line_id + ", skill_points=" + skill_points + ", name=" + name
				+ ", description=" + description + ", image_set_id=" + image_set_id + ", image_id=" + image_id
				+ ", image_path=" + image_path + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}


}
