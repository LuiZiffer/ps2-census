package census.query.dto.util;

public class DailyRibbon {

	private String count;
	private String time;
	private String date;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "DailyRibbon [count=" + count + ", time=" + time + ", date=" + date + "]";
	}
	
	
}
