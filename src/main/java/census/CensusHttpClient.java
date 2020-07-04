package census;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

public class CensusHttpClient {
	private static OkHttpClient client;
	public static final long max_missed_hearbeats = 3;
	public static final long fixed_interval_in_s = 31; //Heartbeat period = 30s + tolerance(1s)
	
	private CensusHttpClient() {
		
	}
	
	public static OkHttpClient getHttpClient() {
		if (client == null) {
			client = new OkHttpClient.Builder()
					.connectTimeout(30, TimeUnit.SECONDS)
					.readTimeout((max_missed_hearbeats + 1) * fixed_interval_in_s, TimeUnit.SECONDS)
					.writeTimeout(30, TimeUnit.SECONDS)
					.connectionPool(new ConnectionPool(0, 1, TimeUnit.MINUTES))
					.build();
		}
		return client;
	}
}
