package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class MarketingBundleItem extends CensusCollectionImpl {

	private String marketing_bundle_id;
	private String item_id;
	private String quantity;
	private String release_time;
	
	public MarketingBundleItem() {
		super(Collection.MARKETING_BUNDLE_ITEM);
		// TODO Auto-generated constructor stub
	}

	public String getMarketing_bundle_id() {
		return marketing_bundle_id;
	}

	public void setMarketing_bundle_id(String marketing_bundle_id) {
		this.marketing_bundle_id = marketing_bundle_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRelease_time() {
		return release_time;
	}

	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}

	@Override
	public String toString() {
		return "MarketingBundleItem [marketing_bundle_id=" + marketing_bundle_id + ", item_id=" + item_id
				+ ", quantity=" + quantity + ", release_time=" + release_time + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}
	
}
