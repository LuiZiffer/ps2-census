package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class ItemCategory extends CensusCollectionImpl {

	private String item_category_id;
	private LanguageObject name;
	
	public ItemCategory() {
		super(Collection.ITEM_CATEGORY);
		// TODO Auto-generated constructor stub
	}

	public String getItem_category_id() {
		return item_category_id;
	}

	public void setItem_category_id(String item_category_id) {
		this.item_category_id = item_category_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ItemCategory [item_category_id=" + item_category_id + ", name=" + name + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}

}
