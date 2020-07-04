package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class SkillSet extends CensusCollectionImpl {

	private String skill_set_id;
	private LanguageObject name;
	private LanguageObject description;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public SkillSet() {
		super(Collection.SKILL_SET);
		// TODO Auto-generated constructor stub
	}

	public String getSkill_set_id() {
		return skill_set_id;
	}

	public void setSkill_set_id(String skill_set_id) {
		this.skill_set_id = skill_set_id;
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
		return "SkillSet [skill_set_id=" + skill_set_id + ", name=" + name + ", description=" + description
				+ ", image_set_id=" + image_set_id + ", image_id=" + image_id + ", image_path=" + image_path
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
