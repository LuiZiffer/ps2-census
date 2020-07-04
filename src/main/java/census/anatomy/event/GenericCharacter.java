package census.anatomy.event;

public enum GenericCharacter {
	ALL("all");
	
private String value;
	
	private GenericCharacter(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
