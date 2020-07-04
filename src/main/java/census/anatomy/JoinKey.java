package census.anatomy;

public enum JoinKey {
    HIDE("hide"),
    INJECT_AT("inject_at"),
    LIST("list"),
    ON("on"),
    OUTER("outer"),
    SHOW("show"),
    TERMS("terms"),
    TO("to");
	
	private String value;
	
	private JoinKey(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
