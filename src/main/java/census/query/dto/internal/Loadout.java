package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class Loadout extends CensusCollectionImpl {

	private String loadout_id;
	private String profile_id;
	private String faction_id;
	private String code_name;
	
	public Loadout() {
		super(Collection.LOADOUT);
		// TODO Auto-generated constructor stub
	}

	public String getLoadout_id() {
		return loadout_id;
	}

	public void setLoadout_id(String loadout_id) {
		this.loadout_id = loadout_id;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(String faction_id) {
		this.faction_id = faction_id;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	@Override
	public String toString() {
		return "Loadout [loadout_id=" + loadout_id + ", profile_id=" + profile_id + ", faction_id=" + faction_id
				+ ", code_name=" + code_name + ", nestedCollections=" + nestedCollections + ", collection=" + collection
				+ "]";
	}
	
}
