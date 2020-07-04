package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class ImageSet extends CensusCollectionImpl {

	private String image_set_id;
	private String image_id;
	private String description;
	private String type_id;
	private String type_description;
	private String image_path;
	
	public ImageSet() {
		super(Collection.IMAGE_SET);
		// TODO Auto-generated constructor stub
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_description() {
		return type_description;
	}

	public void setType_description(String type_description) {
		this.type_description = type_description;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	@Override
	public String toString() {
		return "ImageSet [image_set_id=" + image_set_id + ", image_id=" + image_id + ", description=" + description
				+ ", type_id=" + type_id + ", type_description=" + type_description + ", image_path=" + image_path
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
