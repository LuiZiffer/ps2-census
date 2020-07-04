package census.query.dto.util;

public class BattleRank {

	private String percent_to_next;
	private String value;
	
	public String getPercent_to_next() {
		return percent_to_next;
	}
	public void setPercent_to_next(String percent_to_next) {
		this.percent_to_next = percent_to_next;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "BattleRank [percent_to_next=" + percent_to_next + ", value=" + value + "]";
	}
	
	
}
