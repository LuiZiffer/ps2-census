package census;

import java.util.concurrent.TimeUnit;

import census.logging.CensusInterceptor;
import census.logging.LoggingInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

public class CensusHttpClient {

	public static final long max_missed_hearbeats = 3;
	public static final long fixed_interval_in_s = 31; //Heartbeat period = 30s + tolerance(1s)

	private static CensusInterceptor censusInterceptor = new CensusInterceptor();
	private static LoggingInterceptor loggingInterceptor = new LoggingInterceptor();

	private static final OkHttpClient client = new OkHttpClient.Builder()
			.connectTimeout(30, TimeUnit.SECONDS)
			.readTimeout((max_missed_hearbeats + 1) * fixed_interval_in_s, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.connectionPool(new ConnectionPool(0, 1, TimeUnit.MINUTES))
			.followRedirects(false)
			.addNetworkInterceptor(loggingInterceptor)
			.build();

	private CensusHttpClient() {}
	
	public static OkHttpClient getHttpClient() {
		return client.newBuilder().addInterceptor(censusInterceptor).build();
	}

	public static OkHttpClient getStreamClient() {
		return client.newBuilder().build();
	}

	/**
	 * Sets maximum number of retries in case of failure (default = 3)
	 * @param maxRetries
	 */
	public static void setMaxRetries(long maxRetries) {
		censusInterceptor.setMaxRetries(maxRetries);
	}

	/**
	 * Returns max number of retries
	 * @return maxRetries
	 */
	public static long getMaxRetries() {
		return censusInterceptor.getMaxRetries();
	}
}
