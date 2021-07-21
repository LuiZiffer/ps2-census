package census.exception;

import census.MaintenanceReport;
import census.anatomy.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.Response;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

public class CensusExceptionFactory {

    private CensusExceptionFactory() {}

    private static Map<String, List<String>> splitQuery(URL url) throws UnsupportedEncodingException {
        if (url.getQuery() == null || url.getQuery().isEmpty()) {
            return Collections.emptyMap();
        }
        try {
            return Arrays.stream(url.getQuery().split("&"))
                    .map(CensusExceptionFactory::splitQueryParameter)
                    .collect(Collectors.groupingBy(AbstractMap.SimpleImmutableEntry::getKey, LinkedHashMap::new,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        } catch (RuntimeException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        }
    }

    private static AbstractMap.SimpleImmutableEntry<String, String> splitQueryParameter(String it) throws RuntimeException {
        final int idx = it.indexOf("=");
        final String key = idx > 0 ? it.substring(0, idx) : it;
        final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
        try {
            return new AbstractMap.SimpleImmutableEntry<>(
                    URLDecoder.decode(key, "UTF-8"),
                    URLDecoder.decode(value, "UTF-8")
            );
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates an {@link CensusRedirectException}
     * @param response
     * @return
     */
    public static CensusRedirectException createRedirectException(Response response) {
        if (response.isRedirect()) {
            return new CensusRedirectException("Census has attempted to redirect the request to \"" +
                    response.request().url().query() + "\"", response.request().url().toString());
        } else
            return null;

    }

    /**
     * Census error handling based off of <a href="https://github.com/leonhard-s/auraxium/blob/bd8a401732ebabdfa1d6a6865e57ca83fa9796d6/auraxium/request.py#L177-L315">leonhard-s/auraxium</a>
     * @param json
     * @param url
     * @return
     */
    public static CensusException createCensusException(JsonNode json, URL url) throws IllegalArgumentException, UnsupportedEncodingException {
        String[] components = url.getPath().substring(url.getPath().indexOf("s:")).split("/");
        components = Arrays.stream(components).skip(2).toArray(String[]::new);
        String namespace, collection = null;
        if (components.length <= 0 || components.length > 2)
            throw new IllegalArgumentException("URL: " + url + " does not match required format");
        else {
            namespace = components[0];

            if (components.length == 2) {
                collection = components[1];
            }
        }
        Map<String, List<String>> query = splitQuery(url);

        if (json.hasNonNull("error") && !json.get("error").asText().isEmpty()) {
            String msg = json.get("error").asText();
            if (msg.startsWith("No data found.")) {
                if (collection == null)
                    return new CensusUnknownCollectionException("The namespace \"" + namespace + "\" does not exist",
                            url.toString(), namespace, collection);
                return new CensusUnknownCollectionException("No collection at \"" + namespace + "/" + collection + "\"",
                        url.toString(), namespace, collection);
            }
            if (msg.startsWith("Bad request syntax.")) {
                return new CensusBadRequestSyntaxException("An error occurred in the ps2-census-java api. " +
                        "Please report this at https://github.com/LuiZiffer/ps2-census/issues", url.toString());
            }
            if (msg.startsWith("service_unavailable")) {
                return new CensusServiceUnavailableException("This component of the census api is currently unavailable. " +
                        "Please try again later.", url.toString());
            }
            if (msg.startsWith("Provided Service ID is not registered.")) {
                return new CensusInvalidServiceIdException("The service ID specified is unknown. " +
                        "Check your spelling or wait for the email response validating your service ID.", url.toString());
            }
            if (msg.startsWith("Missing Service ID.")) {
                return new CensusMissingServiceIdException("The default service ID \"s:example\" is for casual use only. " +
                        "Wait 60 seconds or apply for your own service ID at http://census.daybreakgames.com/#devSignup",
                        url.toString());
            }
        } else if (json.hasNonNull("errorCode") && !json.get("errorCode").asText().isEmpty()) {
            String code = json.get("errorCode").asText();
            if (json.hasNonNull("errorMessage") && !json.get("errorMessage").asText().isEmpty()) {
                String msg = json.get("errorMessage").asText();

                if (code.equals("SERVER_ERROR")) {
                    if (msg.startsWith("INVALID_SEARCH_TERM")) {
                        String body = msg.substring("INVALID_SEARCH_TERM:".length()).trim();
                        if (body.startsWith("Invalid search term. Valid search terms:")) {
                            String queryStr = body.split(":", 2)[1]
                                    .replaceAll("\\[", "").replaceAll("\\]","").trim();
                            List<String> fields = Arrays.stream(queryStr.split(","))
                                    .map(str -> str.trim())
                                    .collect(Collectors.toList());

                            String culprit = query.entrySet().stream()
                                    .map(entry -> entry.getKey())
                                    .filter(key -> !fields.contains(key))
                                    .findFirst().orElse(null);

                            String fieldInfo = culprit == null ? "field" : culprit;
                            return new CensusInvalidSearchTermException("Invalid " + fieldInfo + " for collection \"" +
                                    namespace + "/" + collection + "\". Valid field names: " + fields,
                                    url.toString(), namespace, collection, culprit);
                        }
                        if (body.startsWith("Invalid search term:")) {
                            String field = body.split(":", 2)[1].split("\\s+")[0];
                            String[] values = query.get(field).stream().toArray(String[]::new);
                            return new CensusInvalidSearchTermException("Invalid value(s) \"" + values + "\" for field \"" +
                                    field + "\" of collection \"" + namespace + "/" + collection + "\".",
                                    url.toString(), namespace, collection, field);
                        }
                        if (body.startsWith("Invalid search value for term:")) {
                            String field = body.split(":", 2)[1].split("\\s+")[0];
                            String[] values = query.get(field).stream().toArray(String[]::new);
                            return new CensusInvalidSearchTermException("Invalid value(s) \"" + values + "\" for field \"" +
                                    field + "\" of collection \"" + namespace + "/" + collection + "\". " +
                                    "At least three characters must be provided in addition to the regex flag.",
                                    url.toString(), namespace, collection, field);
                        }
                        if (body.startsWith("c:show or c:hide resulted")) {
                            String method = url.toString().contains("c:show") ? "show" : "hide";
                            return new CensusInvalidSearchTermException("Invalid field names specified for " +
                                    "Query." + method + "(...).",
                                    url.toString(), namespace, collection, "c:" + method);
                        }
                    }
                    return new CensusServerException("Error Code: \"" + code + "\", error message: \"" + msg + "\"",
                            url.toString());
                }
            }
            if (code.equals("SERVER_ERROR")) {
                return new CensusServerException("Unknown server error", url.toString());
            }
            return new CensusException("An unknown error has occurred: \"" + code + "\"", url.toString());
        }
        return null;
    }
}
