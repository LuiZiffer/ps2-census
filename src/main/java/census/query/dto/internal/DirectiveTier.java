package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class DirectiveTier extends CensusCollectionImpl {

	private String directive_tree_id;
	private String directive_tier_id;
	private String directive_points;
	private String completion_count;
	private LanguageObject name;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public DirectiveTier() {
		super(Collection.DIRECTIVE_TIER);
		// TODO Auto-generated constructor stub
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

	public String getDirective_points() {
		return directive_points;
	}

	public void setDirective_points(String directive_points) {
		this.directive_points = directive_points;
	}

	public String getCompletion_count() {
		return completion_count;
	}

	public void setCompletion_count(String completion_count) {
		this.completion_count = completion_count;
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
		return "DirectiveTier [directive_tree_id=" + directive_tree_id + ", directive_tier_id=" + directive_tier_id
				+ ", directive_points=" + directive_points + ", completion_count=" + completion_count + ", name=" + name
				+ ", image_set_id=" + image_set_id + ", image_id=" + image_id + ", image_path=" + image_path
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
