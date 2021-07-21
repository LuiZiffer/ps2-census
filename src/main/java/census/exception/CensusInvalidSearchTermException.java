package census.exception;

import com.fasterxml.jackson.databind.JsonNode;

public class CensusInvalidSearchTermException extends CensusException {

	private String namespace;
	private String collection;
	private String field;

	protected CensusInvalidSearchTermException(String errMessage, String url, String namespace, String collection,
											   String field) {
		super(errMessage, url);
		this.namespace = namespace;
		this.collection = collection;
		this.field = field;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getCollection() {
		return collection;
	}

	public String getField() {
		return field;
	}
}
