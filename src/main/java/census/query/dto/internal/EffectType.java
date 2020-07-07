package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class EffectType extends CensusCollectionImpl {

	private String effect_type_id;
	private String description;
	private String param1;
	private String param3;
	
	public EffectType() {
		super(Collection.EFFECT_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getEffect_type_id() {
		return effect_type_id;
	}

	public void setEffect_type_id(String effect_type_id) {
		this.effect_type_id = effect_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	@Override
	public String toString() {
		return "EffectType [effect_type_id=" + effect_type_id + ", description=" + description + ", param1=" + param1
				+ ", param3=" + param3 + ", nestedCollections=" + nestedCollections + ", collection=" + collection
				+ "]";
	}
	
	
}
