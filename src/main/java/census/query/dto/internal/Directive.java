package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class Directive extends CensusCollectionImpl {

	private String directive_id;
	private String directive_tree_id;
	private String directive_tier_id;
	private String objective_set_id;
	private LanguageObject name;
	private LanguageObject description;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public Directive() {
		super(Collection.DIRECTIVE);
		// TODO Auto-generated constructor stub
	}

	public String getDirective_id() {
		return directive_id;
	}

	public void setDirective_id(String directive_id) {
		this.directive_id = directive_id;
	}

	public String getDirective_tree_id() {
		return directive_tree_id;
	}

	public void setDirective_tree_id(String directive_tree_id) {
		this.directive_tree_id = directive_tree_id;
	}

	public String getDirective_tier_id() {
		return directive_tier_id;
	}

	public void setDirective_tier_id(String directive_tier_id) {
		this.directive_tier_id = directive_tier_id;
	}

	public String getObjective_set_id() {
		return objective_set_id;
	}

	public void setObjective_set_id(String objective_set_id) {
		this.objective_set_id = objective_set_id;
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
		return "Directive [directive_id=" + directive_id + ", directive_tree_id=" + directive_tree_id
				+ ", directive_tier_id=" + directive_tier_id + ", objective_set_id=" + objective_set_id + ", name="
				+ name + ", description=" + description + ", image_set_id=" + image_set_id + ", image_id=" + image_id
				+ ", image_path=" + image_path + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

	
}
