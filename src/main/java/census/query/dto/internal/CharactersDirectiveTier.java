package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class CharactersDirectiveTier extends CensusCollectionImpl {

	private String character_id;
	private String directive_tree_id;
	private String directive_tier_id;
	private String completion_time;
	private String completion_time_date;
	
	public CharactersDirectiveTier() {
		super(Collection.CHARACTERS_DIRECTIVE_TIER);
		
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getDirective_tree_id() {
		return directive_tree_id;
	}

	public void setDirective_tree_id(String directive_tree_id) {
		this.directive_tree_id = directive_tree_id;
	}

	public String getDirective_tier_id() {
		return directive_tier_id;
	}

	public void setDirective_tier_id(String directive_tier_id) {
		this.directive_tier_id = directive_tier_id;
	}

	public String getCompletion_time() {
		return completion_time;
	}

	public void setCompletion_time(String completion_time) {
		this.completion_time = completion_time;
	}

	public String getCompletion_time_date() {
		return completion_time_date;
	}

	public void setCompletion_time_date(String completion_time_date) {
		this.completion_time_date = completion_time_date;
	}

	@Override
	public String toString() {
		return "CharactersDirectiveTier [character_id=" + character_id + ", directive_tree_id=" + directive_tree_id
				+ ", directive_tier_id=" + directive_tier_id + ", completion_time=" + completion_time
				+ ", completion_time_date=" + completion_time_date + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

}
