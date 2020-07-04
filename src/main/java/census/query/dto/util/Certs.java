package census.query.dto.util;

public class Certs {

	private String earned_points;
	private String gifted_points;
	private String spent_points;
	private String available_points;
	private String percent_to_next;
	public String getEarned_points() {
		return earned_points;
	}
	public void setEarned_points(String earned_points) {
		this.earned_points = earned_points;
	}
	public String getGifted_points() {
		return gifted_points;
	}
	public void setGifted_points(String gifted_points) {
		this.gifted_points = gifted_points;
	}
	public String getSpent_points() {
		return spent_points;
	}
	public void setSpent_points(String spent_points) {
		this.spent_points = spent_points;
	}
	public String getAvailable_points() {
		return available_points;
	}
	public void setAvailable_points(String available_points) {
		this.available_points = available_points;
	}
	public String getPercent_to_next() {
		return percent_to_next;
	}
	public void setPercent_to_next(String percent_to_next) {
		this.percent_to_next = percent_to_next;
	}
	@Override
	public String toString() {
		return "Certs [earned_points=" + earned_points + ", gifted_points=" + gifted_points + ", spent_points="
				+ spent_points + ", available_points=" + available_points + ", percent_to_next=" + percent_to_next
				+ "]";
	}
	
	
}
