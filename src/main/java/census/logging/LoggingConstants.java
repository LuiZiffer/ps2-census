package census.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class LoggingConstants {
    public static final Marker censusEvent = MarkerFactory.getMarker("CENSUS_EVENT");
    public static final Marker censusQuery = MarkerFactory.getMarker("CENSUS_QUERY");
    public static final Marker censusNetwork = MarkerFactory.getMarker("CENSUS_NETWORK");

    private LoggingConstants() {}
}
