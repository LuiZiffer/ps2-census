package census.query.dto.internal;

import com.fasterxml.jackson.databind.JsonNode;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.tree.TreeNode;

public class ArmorInfo extends CensusCollectionImpl {

	private String armor_info_id;
	private String armor_facing_id;
	private String armor_percent;
	private String description;
	
	public ArmorInfo() {
		super(Collection.ARMOR_INFO);
		
	}

	public String getArmor_info_id() {
		return armor_info_id;
	}

	public void setArmor_info_id(String armor_info_id) {
		this.armor_info_id = armor_info_id;
	}

	public String getArmor_facing_id() {
		return armor_facing_id;
	}

	public void setArmor_facing_id(String armor_facing_id) {
		this.armor_facing_id = armor_facing_id;
	}

	public String getArmor_percent() {
		return armor_percent;
	}

	public void setArmor_percent(String armor_percent) {
		this.armor_percent = armor_percent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ArmorInfo [armor_info_id=" + armor_info_id + ", armor_facing_id=" + armor_facing_id + ", armor_percent="
				+ armor_percent + ", description=" + description + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

	

}
