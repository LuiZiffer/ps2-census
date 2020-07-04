package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class Profile2 extends CensusCollectionImpl {

	private String profile_id;
	private String description;
	
	public Profile2() {
		super(Collection.PROFILE_2);
		// TODO Auto-generated constructor stub
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Profile2 [profile_id=" + profile_id + ", description=" + description + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}


}
