package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class Zone extends CensusCollectionImpl {

	private String zone_id;
	private String code;
	private String hex_size;
	private LanguageObject name;
	private LanguageObject description;
	private String geometry_id;
	private String dynamic;

	public Zone() {
		super(Collection.ZONE);
		// TODO Auto-generated constructor stub
	}

	public String getGeometry_id() {
		return geometry_id;
	}

	public void setGeometry_id(String geometry_id) {
		this.geometry_id = geometry_id;
	}

	public String getDynamic() {
		return dynamic;
	}

	public void setDynamic(String dynamic) {
		this.dynamic = dynamic;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHex_size() {
		return hex_size;
	}

	public void setHex_size(String hex_size) {
		this.hex_size = hex_size;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	public LanguageObject getDescription() {
		return description;
	}

	public void setDescription(LanguageObject description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Zone [zone_id=" + zone_id + ", code=" + code + ", hex_size=" + hex_size + ", name=" + name
				+ ", description=" + description + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

}
