package census.exception;

public class CensusRedirectException extends CensusException {
    protected CensusRedirectException(String errMessage, String url) {
        super(errMessage, url);
    }
}
