package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class Experience extends CensusCollectionImpl {

	private String experience_id;
	private String description;
	private String xp;
	
	public Experience() {
		super(Collection.EXPERIENCE);
		// TODO Auto-generated constructor stub
	}

	public String getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(String experience_id) {
		this.experience_id = experience_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getXp() {
		return xp;
	}

	public void setXp(String xp) {
		this.xp = xp;
	}

	@Override
	public String toString() {
		return "Experience [experience_id=" + experience_id + ", description=" + description + ", xp=" + xp
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}
	
	

}
