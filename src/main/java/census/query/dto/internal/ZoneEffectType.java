package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ZoneEffectType extends CensusCollectionImpl {

	private String zone_effect_type_id;
	private String description;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	
	public ZoneEffectType() {
		super(Collection.ZONE_EFFECT_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getZone_effect_type_id() {
		return zone_effect_type_id;
	}

	public void setZone_effect_type_id(String zone_effect_type_id) {
		this.zone_effect_type_id = zone_effect_type_id;
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

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
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

	@Override
	public String toString() {
		return "ZoneEffectType [zone_effect_type_id=" + zone_effect_type_id + ", description=" + description
				+ ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4=" + param4
				+ ", param5=" + param5 + ", param6=" + param6 + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}


}
