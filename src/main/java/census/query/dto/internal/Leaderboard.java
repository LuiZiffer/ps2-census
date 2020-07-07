package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class Leaderboard extends CensusCollectionImpl {

	private String character_id;
	private String value;
	private String rank;
	
	/**
	 * To retrieve data of this collection you need to specify the arguments:
	 * name [Deaths, Kills, Score, Time]
	 * period [Forever, Monthly, Weekly, Daily, OneLife]
	 * 
	 */
	public Leaderboard() {
		super(Collection.LEADERBOARD);
		// TODO Auto-generated constructor stub
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Leaderboard [character_id=" + character_id + ", value=" + value + ", rank=" + rank
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
