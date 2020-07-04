package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class MarketingBundleWithOneItem extends CensusCollectionImpl {

	private String marketing_bundle_id;
	private String item_id;
	private String item_quantity;
	private String station_cash_price;
	private String release_time;
	
	public MarketingBundleWithOneItem() {
		super(Collection.MARKETING_BUNDLE_WITH_ONE_ITEM);
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

	public String getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(String item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getStation_cash_price() {
		return station_cash_price;
	}

	public void setStation_cash_price(String station_cash_price) {
		this.station_cash_price = station_cash_price;
	}

	public String getRelease_time() {
		return release_time;
	}

	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}

	@Override
	public String toString() {
		return "MarketingBundleWithOneItem [marketing_bundle_id=" + marketing_bundle_id + ", item_id=" + item_id
				+ ", item_quantity=" + item_quantity + ", station_cash_price=" + station_cash_price + ", release_time="
				+ release_time + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
