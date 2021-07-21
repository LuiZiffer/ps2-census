package census.exception;

import java.io.IOException;

public class CensusException extends Exception {

    private String url;

    protected CensusException(String errMessage, String url) {
        super(errMessage);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
