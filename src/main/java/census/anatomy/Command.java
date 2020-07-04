package census.anatomy;

public enum Command {
    CASE("case"),
    DISTINCT("distinct"),
    EXACT_MATCH_FIRST("exactMatchFirst"),
    HAS("has"),
    HIDE("hide"),
    INCLUDE_NULL("includeNull"),
    JOIN("join"),
    LANG("lang"),
    LIMIT("limit"),
    LIMIT_PER_DB("limitPerDB"),
    RETRY("retry"),
    SHOW("show"),
    SORT("sort"),
    START("start"),
    TIMING("timing"),
    TREE("tree");
	
	private String value;
	
	private Command(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
