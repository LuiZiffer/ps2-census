package census.anatomy;

public enum Namespace {
	PS2("ps2"),
    PS2_V1("ps2:v1"),
    PS2_V2("ps2:v2"),
	GLOBAL("global");
	
	private String value;
	
	private Namespace(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
