package census.anatomy;

public enum Constants {
	COMMAND_PREFIX("c:"),
	SERVICE_ID_PREFIX("s:"),
	FIELD_SEPARATOR(","),
	JOIN_ITEM_DELIMITER("^"),
	JOIN_VALUE_DELIMITER("'"),
	TREE_ITEM_DELIMITER("^"),
	TREE_VALUE_DELIMITER("'"),
	EXAMPLE_SERVICE_ID("example"),
	CENSUS_ENDPOINT("http://census.daybreakgames.com"),
	PUSH_ENDPOINT("wss://push.planetside2.com/streaming");
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
