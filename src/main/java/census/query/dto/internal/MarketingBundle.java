package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class MarketingBundle extends CensusCollectionImpl {

	private String marketing_bundle_id;
	private LanguageObject name;
	private LanguageObject description;
	private String image_id;
	private String station_cash_price;
	private String release_time;
	
	public MarketingBundle() {
		super(Collection.MARKETING_BUNDLE);
		// TODO Auto-generated constructor stub
	}

	public String getMarketing_bundle_id() {
		return marketing_bundle_id;
	}

	public void setMarketing_bundle_id(String marketing_bundle_id) {
		this.marketing_bundle_id = marketing_bundle_id;
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

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
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
		return "MarketingBundle [marketing_bundle_id=" + marketing_bundle_id + ", name=" + name + ", description="
				+ description + ", image_id=" + image_id + ", station_cash_price=" + station_cash_price
				+ ", release_time=" + release_time + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

}
