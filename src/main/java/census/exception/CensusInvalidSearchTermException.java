package census.exception;

import com.fasterxml.jackson.databind.JsonNode;

public class CensusInvalidSearchTermException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8644016120503500021L;
	private String errorCode;
	
	public CensusInvalidSearchTermException(JsonNode node) {
		super(node.path("errorMessage").asText());
		errorCode = node.path("errorCode").asText();
	}

	@Override
	public String getMessage() {
		return "[" + errorCode + "] " + super.getMessage();
	}
}
