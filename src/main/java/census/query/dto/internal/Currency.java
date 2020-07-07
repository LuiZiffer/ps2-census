package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class Currency extends CensusCollectionImpl {

	private String currency_id;
	private LanguageObject name;
	private String icon_id;
	private String inventory_cap;
	
	public Currency() {
		super(Collection.CURRENCY);
		// TODO Auto-generated constructor stub
	}

	public String getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Currency [currency_id=" + currency_id + ", name=" + name + ", icon_id=" + icon_id + ", inventory_cap="
				+ inventory_cap + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	
	
}
