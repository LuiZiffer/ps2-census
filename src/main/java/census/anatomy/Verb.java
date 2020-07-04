package census.anatomy;

public enum Verb {
    COUNT("count"),
    GET("get");
	
	private String value;
	
	private Verb(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
