package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class ProfileArmorMap extends CensusCollectionImpl {

	private String profile_id;
	private String armor_info_id;
	private String rank;
	
	public ProfileArmorMap() {
		super(Collection.PROFILE_ARMOR_MAP);
		// TODO Auto-generated constructor stub
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getArmor_info_id() {
		return armor_info_id;
	}

	public void setArmor_info_id(String armor_info_id) {
		this.armor_info_id = armor_info_id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "ProfileArmorMap [profile_id=" + profile_id + ", armor_info_id=" + armor_info_id + ", rank=" + rank
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
