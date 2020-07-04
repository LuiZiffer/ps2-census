package census.anatomy;

public enum SearchModifier {
    CONTAINS("*"),
    GREATER(">"),
    GREATER_OR_EQUAL("]"),
    LESS("<"),
    LESS_OR_EQUAL("["),
    NOT("!"),
    STARTS_WITH("^");
	
	private String value;
	
	private SearchModifier(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
