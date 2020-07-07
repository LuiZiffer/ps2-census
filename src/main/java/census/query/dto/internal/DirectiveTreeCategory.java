package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class DirectiveTreeCategory extends CensusCollectionImpl {

	private String directive_tree_category_id;
	private LanguageObject name;
	
	public DirectiveTreeCategory() {
		super(Collection.DIRECTIVE_TREE_CATEGORY);
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "DirectiveTreeCategory [directive_tree_category_id=" + directive_tree_category_id + ", name=" + name
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
