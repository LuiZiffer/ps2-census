package census.logging;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        logger.debug(LoggingConstants.censusNetwork, String.format("Sending request %s",
                request.url()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        logger.debug(LoggingConstants.censusNetwork, String.format("Received response (%d) for %s in %.1fms%n%s",
                response.code(), response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}
