package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class Achievement extends CensusCollectionImpl {
	
	private String achievement_id;
	private String item_id;
	private String objective_group_id;
	private String reward_id;
	private String repeatable;
	private LanguageObject name;
	private LanguageObject description;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public Achievement() {
		super(Collection.ACHIEVEMENT);
		
	}
	
	public String getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getObjective_group_id() {
		return objective_group_id;
	}

	public void setObjective_group_id(String objective_group_id) {
		this.objective_group_id = objective_group_id;
	}

	public String getReward_id() {
		return reward_id;
	}

	public void setReward_id(String reward_id) {
		this.reward_id = reward_id;
	}

	public String getRepeatable() {
		return repeatable;
	}

	public void setRepeatable(String repeatable) {
		this.repeatable = repeatable;
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
		return "Achievement [achievement_id=" + achievement_id + ", item_id=" + item_id + ", objective_group_id="
				+ objective_group_id + ", reward_id=" + reward_id + ", repeatable=" + repeatable + ", name=" + name
				+ ", description=" + description + ", image_set_id=" + image_set_id + ", image_id=" + image_id
				+ ", image_path=" + image_path + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

	

	
	
}
