package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ResistInfo extends CensusCollectionImpl {

	private String resist_info_id;
	private String resist_type_id;
	private String resist_percent;
	private String multiplier_when_headshot;
	private String description;
	
	public ResistInfo() {
		super(Collection.RESIST_INFO);
		// TODO Auto-generated constructor stub
	}

	public String getResist_info_id() {
		return resist_info_id;
	}

	public void setResist_info_id(String resist_info_id) {
		this.resist_info_id = resist_info_id;
	}

	public String getResist_type_id() {
		return resist_type_id;
	}

	public void setResist_type_id(String resist_type_id) {
		this.resist_type_id = resist_type_id;
	}

	public String getResist_percent() {
		return resist_percent;
	}

	public void setResist_percent(String resist_percent) {
		this.resist_percent = resist_percent;
	}

	public String getMultiplier_when_headshot() {
		return multiplier_when_headshot;
	}

	public void setMultiplier_when_headshot(String multiplier_when_headshot) {
		this.multiplier_when_headshot = multiplier_when_headshot;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResistInfo [resist_info_id=" + resist_info_id + ", resist_type_id=" + resist_type_id
				+ ", resist_percent=" + resist_percent + ", multiplier_when_headshot=" + multiplier_when_headshot
				+ ", description=" + description + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}


}
