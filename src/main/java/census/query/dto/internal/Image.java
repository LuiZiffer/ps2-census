package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class Image extends CensusCollectionImpl {

	private String image_id;
	private String path;
	
	public Image() {
		super(Collection.IMAGE);
		// TODO Auto-generated constructor stub
	}

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Image [image_id=" + image_id + ", path=" + path + ", nestedCollections=" + nestedCollections
				+ ", collection=" + collection + "]";
	}

}
