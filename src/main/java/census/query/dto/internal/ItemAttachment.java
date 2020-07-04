package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class ItemAttachment extends CensusCollectionImpl {

	private String item_id;
	private String attachment_item_id;
	
	public ItemAttachment() {
		super(Collection.ITEM_ATTACHMENT);
		// TODO Auto-generated constructor stub
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getAttachment_item_id() {
		return attachment_item_id;
	}

	public void setAttachment_item_id(String attachment_item_id) {
		this.attachment_item_id = attachment_item_id;
	}

	
}
