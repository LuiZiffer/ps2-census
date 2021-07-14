package census.exception;

public class CensusUnknownCollectionException extends CensusException {

    private String collection;
    private String namespace;

    protected CensusUnknownCollectionException(String errMessage, String url) {
        super(errMessage, url);
    }

    protected  CensusUnknownCollectionException(String errMessage, String url, String namespace, String collection) {
        this(errMessage, url);
        this.namespace = namespace;
        this.collection = collection;
    }

    public String getCollection() {
        return collection;
    }

    public String getNamespace() {
        return namespace;
    }
}
