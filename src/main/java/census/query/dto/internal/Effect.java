package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class Effect extends CensusCollectionImpl {

	private String effect_id;
	private String effect_type_id;
	private String ability_id;
	private String target_type_id;
	private String resist_type_id;
	private String param1;
	private String param2;
	private String param5;
	private String param6;
	private String param7;
	private String param8;
	private String param9;
	
	public Effect() {
		super(Collection.EFFECT);
		// TODO Auto-generated constructor stub
	}

	public String getEffect_id() {
		return effect_id;
	}

	public void setEffect_id(String effect_id) {
		this.effect_id = effect_id;
	}

	public String getEffect_type_id() {
		return effect_type_id;
	}

	public void setEffect_type_id(String effect_type_id) {
		this.effect_type_id = effect_type_id;
	}

	public String getAbility_id() {
		return ability_id;
	}

	public void setAbility_id(String ability_id) {
		this.ability_id = ability_id;
	}

	public String getTarget_type_id() {
		return target_type_id;
	}

	public void setTarget_type_id(String target_type_id) {
		this.target_type_id = target_type_id;
	}

	public String getResist_type_id() {
		return resist_type_id;
	}

	public void setResist_type_id(String resist_type_id) {
		this.resist_type_id = resist_type_id;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
	}

	public String getParam7() {
		return param7;
	}

	public void setParam7(String param7) {
		this.param7 = param7;
	}

	public String getParam8() {
		return param8;
	}

	public void setParam8(String param8) {
		this.param8 = param8;
	}

	public String getParam9() {
		return param9;
	}

	public void setParam9(String param9) {
		this.param9 = param9;
	}

	@Override
	public String toString() {
		return "Effect [effect_id=" + effect_id + ", effect_type_id=" + effect_type_id + ", ability_id=" + ability_id
				+ ", target_type_id=" + target_type_id + ", resist_type_id=" + resist_type_id + ", param1=" + param1
				+ ", param2=" + param2 + ", param5=" + param5 + ", param6=" + param6 + ", param7=" + param7
				+ ", param8=" + param8 + ", param9=" + param9 + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}
	
}
