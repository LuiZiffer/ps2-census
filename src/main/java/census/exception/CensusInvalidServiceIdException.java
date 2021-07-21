package census.exception;

public class CensusInvalidServiceIdException extends CensusException {
    protected CensusInvalidServiceIdException(String errMessage, String url) {
        super(errMessage, url);
    }
}
