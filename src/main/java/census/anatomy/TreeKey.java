package census.anatomy;

public enum TreeKey {
    FIELD("field"),
    LIST("list"),
    PREFIX("prefix"),
    START("start");
	
	private String value;
	
	private TreeKey(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
