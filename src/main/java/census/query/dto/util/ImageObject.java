package census.query.dto.util;

public class ImageObject {

	private String title;
	private String image_set_id;
	private String image_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	@Override
	public String toString() {
		return "ImageObject [title=" + title + ", image_set_id=" + image_set_id + ", image_id=" + image_id + "]";
	}
	
}
