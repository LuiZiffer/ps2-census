package census.query.dto.util;

public class Name {

	private String first;
	private String first_lower;
	
	public String getFirst() {
		return first;
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public String getFirst_lower() {
		return first_lower;
	}
	
	public void setFirst_lower(String first_lower) {
		this.first_lower = first_lower;
	}
	
	@Override
	public String toString() {
		return "Name [first=" + first + ", first_lower=" + first_lower + "]";
	}

}
