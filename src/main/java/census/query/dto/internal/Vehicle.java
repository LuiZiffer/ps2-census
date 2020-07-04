package census.query.dto.internal;

import java.util.concurrent.atomic.LongAccumulator;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.LanguageObject;

public class Vehicle extends CensusCollectionImpl {

	private String vehicle_id;
	private LanguageObject name;
	private LanguageObject description;
	private String type_id;
	private String type_name;
	private String cost_resource_id;
	private String image_set_id;
	private String image_id;
	private String image_path;
	
	public Vehicle() {
		super(Collection.VEHICLE);
		// TODO Auto-generated constructor stub
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
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

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getCost_resource_id() {
		return cost_resource_id;
	}

	public void setCost_resource_id(String cost_resource_id) {
		this.cost_resource_id = cost_resource_id;
	}

	public String getImage_set_id() {
		return image_set_id;
	}

	public void setImage_set_id(String image_set_id) {
		this.image_set_id = image_set_id;
	}

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", name=" + name + ", description=" + description + ", type_id="
				+ type_id + ", type_name=" + type_name + ", cost_resource_id=" + cost_resource_id + ", image_set_id="
				+ image_set_id + ", image_id=" + image_id + ", image_path=" + image_path + ", nestedCollections="
				+ nestedCollections + ", collection=" + collection + "]";
	}


}
