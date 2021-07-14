package census.exception;

public class CensusMissingServiceIdException extends CensusException {
    protected CensusMissingServiceIdException(String errMessage, String url) {
        super(errMessage, url);
    }
}
