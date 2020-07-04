package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class Title extends CensusCollectionImpl {

	private String title_id;
	private LanguageObject name;
	
	public Title() {
		super(Collection.TITLE);
		// TODO Auto-generated constructor stub
	}

	public String getTitle_id() {
		return title_id;
	}

	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Title [title_id=" + title_id + ", name=" + name + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
