package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class OutfitRank extends CensusCollectionImpl {
	
	private String outfit_id;
	private String ordinal;
	private String name;
	private String description;
	
	public OutfitRank() {
		super(Collection.OUTFIT_RANK);
		// TODO Auto-generated constructor stub
	}

	public String getOutfit_id() {
		return outfit_id;
	}

	public void setOutfit_id(String outfit_id) {
		this.outfit_id = outfit_id;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "OutfitRank [outfit_id=" + outfit_id + ", ordinal=" + ordinal + ", name=" + name + ", description="
				+ description + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
