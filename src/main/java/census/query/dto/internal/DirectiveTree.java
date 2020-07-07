package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class DirectiveTree extends CensusCollectionImpl {

	private String directive_tree_id;
	private String directive_tree_category_id;
	private LanguageObject name;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public DirectiveTree() {
		super(Collection.DIRECTIVE_TREE);
		// TODO Auto-generated constructor stub
	}

	public String getDirective_tree_id() {
		return directive_tree_id;
	}

	public void setDirective_tree_id(String directive_tree_id) {
		this.directive_tree_id = directive_tree_id;
	}

	public String getDirective_tree_category_id() {
		return directive_tree_category_id;
	}

	public void setDirective_tree_category_id(String directive_tree_category_id) {
		this.directive_tree_category_id = directive_tree_category_id;
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
		return "DirectiveTree [directive_tree_id=" + directive_tree_id + ", directive_tree_category_id="
				+ directive_tree_category_id + ", name=" + name + ", image_set_id=" + image_set_id + ", image_id="
				+ image_id + ", image_path=" + image_path + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}
	
	

}
