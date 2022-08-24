package census.logging;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CensusInterceptor implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(CensusInterceptor.class);
    private long maxRetries = 3;

    /**
     * Constructs an Interceptor to retry failed requests (default max retries = 3)
     */
    public CensusInterceptor() {}


    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        // try the request
        Response response = chain.proceed(request);

        int tryCount = 0;
        while (!response.isSuccessful() && tryCount < maxRetries) {

            logger.debug(LoggingConstants.censusQuery,
                    "Request is not successful - attempt: " + (tryCount + 1) + "/" + maxRetries);

            tryCount++;

            // retry the request
            response.close();
            response = chain.proceed(request);
        }

        // otherwise just pass the original response on
        return response;
    }

    public long getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(long maxRetries) {
        this.maxRetries = maxRetries;
    }
}
