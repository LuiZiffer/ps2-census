package census.query.dto.internal;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.tree.Pair;
import census.tree.TreeNode;

public class OutfitMemberExtended extends CensusCollectionImpl {

	private String character_id;
	private String member_since;
	private String member_since_date;
	private String member_rank;
	private String member_rank_ordinal;
	private String outfit_id;
	private String name;
	private String name_lower;
	private String alias;
	private String alias_lower;
	private String time_created;
	private String time_created_date;
	private String leader_character_id;
	private String member_count;
	
	public OutfitMemberExtended() {
		super(Collection.OUTFIT_MEMBER_EXTENDED);
		// TODO Auto-generated constructor stub
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

	public String getMember_rank() {
		return member_rank;
	}

	public void setMember_rank(String member_rank) {
		this.member_rank = member_rank;
	}

	public String getMember_rank_ordinal() {
		return member_rank_ordinal;
	}

	public void setMember_rank_ordinal(String member_rank_ordinal) {
		this.member_rank_ordinal = member_rank_ordinal;
	}

	public String getOutfit_id() {
		return outfit_id;
	}

	public void setOutfit_id(String outfit_id) {
		this.outfit_id = outfit_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_lower() {
		return name_lower;
	}

	public void setName_lower(String name_lower) {
		this.name_lower = name_lower;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias_lower() {
		return alias_lower;
	}

	public void setAlias_lower(String alias_lower) {
		this.alias_lower = alias_lower;
	}

	public String getTime_created() {
		return time_created;
	}

	public void setTime_created(String time_created) {
		this.time_created = time_created;
	}

	public String getTime_created_date() {
		return time_created_date;
	}

	public void setTime_created_date(String time_created_date) {
		this.time_created_date = time_created_date;
	}

	public String getLeader_character_id() {
		return leader_character_id;
	}

	public void setLeader_character_id(String leader_character_id) {
		this.leader_character_id = leader_character_id;
	}

	public String getMember_count() {
		return member_count;
	}

	public void setMember_count(String member_count) {
		this.member_count = member_count;
	}

	@Override
	public String toString() {
		return "OutfitMemberExtended [character_id=" + character_id + ", member_since=" + member_since
				+ ", member_since_date=" + member_since_date + ", member_rank=" + member_rank + ", member_rank_ordinal="
				+ member_rank_ordinal + ", outfit_id=" + outfit_id + ", name=" + name + ", name_lower=" + name_lower
				+ ", alias=" + alias + ", alias_lower=" + alias_lower + ", time_created=" + time_created
				+ ", time_created_date=" + time_created_date + ", leader_character_id=" + leader_character_id
				+ ", member_count=" + member_count + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}
	
}
