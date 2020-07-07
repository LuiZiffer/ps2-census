package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class OutfitMember extends CensusCollectionImpl {

	private String outfit_id;
	private String character_id;
	private String member_since;
	private String member_since_date;
	private String rank;
	private String rank_ordinal;
	
	public OutfitMember() {
		super(Collection.OUTFIT_MEMBER);
		// TODO Auto-generated constructor stub
	}

	public String getOutfit_id() {
		return outfit_id;
	}

	public void setOutfit_id(String outfit_id) {
		this.outfit_id = outfit_id;
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getMember_since() {
		return member_since;
	}

	public void setMember_since(String member_since) {
		this.member_since = member_since;
	}

	public String getMember_since_date() {
		return member_since_date;
	}

	public void setMember_since_date(String member_since_date) {
		this.member_since_date = member_since_date;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRank_ordinal() {
		return rank_ordinal;
	}

	public void setRank_ordinal(String rank_ordinal) {
		this.rank_ordinal = rank_ordinal;
	}

	@Override
	public String toString() {
		return "OutfitMember [outfit_id=" + outfit_id + ", character_id=" + character_id + ", member_since="
				+ member_since + ", member_since_date=" + member_since_date + ", rank=" + rank + ", rank_ordinal="
				+ rank_ordinal + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	

	
	
	
}
