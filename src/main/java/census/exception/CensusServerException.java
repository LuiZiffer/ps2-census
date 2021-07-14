package census.exception;

public class CensusServerException extends CensusException {
    protected CensusServerException(String errMessage, String url) {
        super(errMessage, url);
    }
}
