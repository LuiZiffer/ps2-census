package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ProfileResistMap extends CensusCollectionImpl {

	private String profile_id;
	private String resist_info_id;
	private String rank;
	
	public ProfileResistMap() {
		super(Collection.PROFILE_RESIST_MAP);
		// TODO Auto-generated constructor stub
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getResist_info_id() {
		return resist_info_id;
	}

	public void setResist_info_id(String resist_info_id) {
		this.resist_info_id = resist_info_id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "ProfileResistMap [profile_id=" + profile_id + ", resist_info_id=" + resist_info_id + ", rank=" + rank
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
