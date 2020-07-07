package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class Faction extends CensusCollectionImpl {

	private String faction_id;
	private LanguageObject name;
	private String code_tag;
	private String user_selectable;
	
	public Faction() {
		super(Collection.FACTION);
		// TODO Auto-generated constructor stub
	}

	public String getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(String faction_id) {
		this.faction_id = faction_id;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	public String getCode_tag() {
		return code_tag;
	}

	public void setCode_tag(String code_tag) {
		this.code_tag = code_tag;
	}

	public String getUser_selectable() {
		return user_selectable;
	}

	public void setUser_selectable(String user_selectable) {
		this.user_selectable = user_selectable;
	}

	@Override
	public String toString() {
		return "Faction [faction_id=" + faction_id + ", name=" + name + ", code_tag=" + code_tag + ", user_selectable="
				+ user_selectable + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
