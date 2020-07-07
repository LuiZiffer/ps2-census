package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ItemType extends CensusCollectionImpl {

	private String item_type_id;
	private String name;
	private String code;
	
	public ItemType() {
		super(Collection.ITEM_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getItem_type_id() {
		return item_type_id;
	}

	public void setItem_type_id(String item_type_id) {
		this.item_type_id = item_type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ItemType [item_type_id=" + item_type_id + ", name=" + name + ", code=" + code + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}
	
	

}
