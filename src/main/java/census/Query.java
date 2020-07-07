package census;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import census.anatomy.Collection;
import census.anatomy.Command;
import census.anatomy.Constants;
import census.anatomy.Namespace;
import census.anatomy.SearchModifier;
import census.anatomy.Verb;
import census.exception.CensusInvalidSearchTermException;
import census.tree.Pair;
import census.tree.TreeNode;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * This project was inspired by <a href="https://github.com/spascou/ps2-census/blob/ae45552b2465328bf2a7c15651e766911f5807af/ps2_census">ps2_census</a> by liquidwarp.
 * <p>
 * A wrapper for the Planetside 2 Census API <a href="http://census.daybreakgames.com/">Census API</a>.
 * <br>The command c:resolve is not supported as the same functionality is provided by c:join.
 * For a full list of available commands see <a href="http://census.daybreakgames.com/#query-commands">Query Commands</a>.
 * 
 *
 * @author LuiZiffer
 */
public class Query {
	
	private Collection collection;
	private String endpoint;
	private String service_id;
	private Namespace namespace;
	private Map<String,List<String>> parameters;
	private List<Join> joins;
	private OkHttpClient client = CensusHttpClient.getHttpClient();

	/**
	 * Instantiates a {@link Query} with a {@link Collection}, service id, endpoint and {@link Namespace}
	 * @param collection
	 * @param service_id
	 * @param endpoint
	 * @param namespace
	 */
	public Query(Collection collection, String service_id, String endpoint, Namespace namespace) {
		this.collection = collection;
		this.endpoint = endpoint;
		this.service_id = service_id;
		this.namespace = namespace;
		this.parameters = new HashMap<String, List<String>>();
		this.joins = new ArrayList<>();
	}
	
	/**
	 * Instantiates a {@link Query} with a {@link Collection}, service id, endpoint and {@link Namespace#PS2_V2}
	 * @param collection
	 * @param service_id
	 * @param endpoint
	 */
	public Query(Collection collection, String service_id, String endpoint) {
		this(collection, service_id, endpoint, Namespace.PS2_V2);
	}
	
	/**
	 * Instantiates a {@link Query} with a {@link Collection}, service id, endpoint (<a href="http://census.daybreakgames.com/">Census API</a>) and {@link Namespace#PS2_V2}
	 * @param collection
	 * @param service_id
	 */
	public Query(Collection collection, String service_id) {
		this(collection, service_id, Constants.CENSUS_ENDPOINT.toString());
	}
	
	/**
	 * Instantiates a {@link Query} with a {@link Collection}, service id (s:example), endpoint (<a href="http://census.daybreakgames.com/">Census API</a>) and {@link Namespace#PS2_V2}
	 * @param collection
	 */
	public Query(Collection collection) {
		this(collection, Constants.EXAMPLE_SERVICE_ID.toString());
	}
	
	public String getEndpoint() {
		return endpoint;
	}

	public Query setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

	public String getService_id() {
		return service_id;
	}

	public Query setService_id(String service_id) {
		this.service_id = service_id;
		return this;
	}

	public Namespace getNamespace() {
		return namespace;
	}

	public Query setNamespace(Namespace namespace) {
		this.namespace = namespace;
		return this;
	}

	public Collection getCollection() {
		return collection;
	}

	public Map<String, List<String>> getParameters() {
		return parameters;
	}
	
	
	
	private void addParam(String key, String value) {
		if (parameters.containsKey(key)) {
			parameters.get(key).add(value);
		} else {
			parameters.put(key, new ArrayList<String>(Arrays.asList(value)));
		}
	}
	
	private void addParam(Command cmd, String value) {
		addParam(Constants.COMMAND_PREFIX + cmd.toString(), value);
	}

	/**
	 * Create a URL based on the parameters contained within this object
	 * @param verb
	 * @return a URL representation of this object
	 */
	public String url(Verb verb) {
		return endpoint + "/" + Constants.SERVICE_ID_PREFIX + service_id + 
				"/" + verb + 
				"/" + namespace + 
				"/" + collection+
				"/?" + parameters.entrySet().stream()
					.map(e -> e.getKey() + "=" + e.getValue().stream()
							.collect(Collectors.joining(Constants.FIELD_SEPARATOR.toString())))
					.collect(Collectors.joining("&"));
	}
	
	private Call http(String url, int attempts) {
		Request request = new Request.Builder()
				.url(url)
				.build();
		return client.newCall(request);
	}
	
	/**
	 * Synchronous execution of the generated call
	 * @param verb
	 * @return {@link JsonNode} of the response body received
	 * @throws CensusInvalidSearchTermException if the Census API server has responded with an error message
	 * @throws IOException
	 */
	private JsonNode execute(Verb verb) throws CensusInvalidSearchTermException, IOException {
		JsonNode node;
		Response r = http(url(verb), 1).execute();
		node = new ObjectMapper().readTree(r.body().byteStream());
		
		if (node == null) {
			throw new IOException("No data received");
		} else if (node.has("errorCode") || node.has("errorMessage")) {
			throw new CensusInvalidSearchTermException(node);
		} else if (node.has("error")) {
			//error: service_unavailable
			throw new IOException(node.path("error").asText());
		}
		return node;
		
		
	}
	
	/**
	 * Asynchronous execution of the generated call
	 * @param verb
	 * @param cb handles the response received from the Census API server
	 */
	private void execute(Verb verb, Callback cb) {
		http(url(verb),1).enqueue(cb);
	}
	
	
	/**
	 * Synchronous {@link Verb#GET} call, retrieves the data specified by the passed parameters
	 * @return JsonNode of the response body
	 * @throws CensusInvalidSearchTermException if an {@link IOException} has occurred or the server has responded with a service unavailable message
	 * @throws IOException 
	 */
	public JsonNode get() throws CensusInvalidSearchTermException, IOException {
		return execute(Verb.GET);
	}
	
	/**
	 * Asynchronous {@link Verb#GET} call, retrieves the data specified by the passed parameters
	 * @param cb
	 */
	public void get(Callback cb) {
		execute(Verb.GET, cb);
	}
	
	/**
	 * Synchronous {@link Verb#COUNT} call, retrieves the data specified by the passed parameters.
	 * @return count of matching data elements
	 * @throws CensusInvalidSearchTermException if the Census API server has responded with an error message
	 * @throws IOException 
	 */
	public long count() throws CensusInvalidSearchTermException, IOException  {
		return execute(Verb.COUNT).path("count").asLong();
	}
	
	/**
	 * Asynchronous {@link Verb#COUNT} call, retrieves the data specified by the passed parameters.
	 * Response handling is delegated to the user, through {@link Callback}.
	 * @param cb
	 */
	public void count(Callback cb) {
		execute(Verb.COUNT, cb);
	}
	
	/**
	 * Adds a {@link Pair} of {@link SearchModifier} and {@link String} to the parameter list.
	 * {@link SearchModifier}s can vary for the passed arguments
	 * @param field search term of the element used for identification of the data
	 * @param args
	 * @return instance of this object
	 */
	@SuppressWarnings("unchecked")
	public Query filter(String field, Pair<SearchModifier,String>...args) {
		addParam(field, Arrays.asList(args).stream()
				.map(p -> p.left() + p.right())
				.collect(Collectors.joining(Constants.FIELD_SEPARATOR.toString())));
		return this;
	}
	
	/**
	 * Adds a parameter to the list, e.g. <i>.../{Collection}/?{field}={SearchModifier}{value1},{SearchModifier}{value2},...</i>
	 * One {@link SearchModifier} applies to all arguments passed in this parameter list.
	 * @param field search term of the element used for identification of the data
	 * @param modifier
	 * @param args
	 * @return instance of this object
	 */
	public Query filter(String field, SearchModifier modifier, String...args) {
		if (modifier == null) {
			addParam(field, String.join(Constants.FIELD_SEPARATOR.toString(), args));
		} else {
			addParam(field, modifier + String.join(Constants.FIELD_SEPARATOR.toString() + modifier.toString(), args));
		}
		return this;
	}
	
	/**
	 * Adds a parameter to the list, e.g. <i>.../{Collection}/?{field}={value1},{value2},...</i>
	 * @param field search term of the element used for identification of the data
	 * @param args
	 * @return instance of this object
	 */
	public Query filter(String field, String...args) {
		return filter(field, null, args);
	}
	
	
	//Commands specified by http://census.daybreakgames.com/#query-commands
	//resolve command is not supported, as the same functionality is provided by the join command
	
	/**
	 * Only include the provided fields from the object within the result (multiple field names separated by a comma).
	 * @param args
	 * @return instance of this object
	 */
	public Query show(String...args) {
		addParam(Command.SHOW, String.join(Constants.FIELD_SEPARATOR.toString(), args));
		return this;
	}
	
	/**
	 * Include all field except the provided fields from the object within the result (multiple field names separated by a comma).
	 * @param args
	 * @return instance of this object
	 */
	public Query hide(String...args) {
		addParam(Command.HIDE, String.join(Constants.FIELD_SEPARATOR.toString(), args));
		return this;
	}
	
	/**
	 * Sort the results by the field(s) provided (multiple field names separated by a comma). The value after the : is the sort direction.
	 * @param args
	 * @return instance of this object
	 */
	@SuppressWarnings("unchecked")
	public Query sort(Pair<String,Integer>... args) {
		String tmp = Arrays.asList(args).stream()
				.map(p -> p.left() + ":" + Integer.toString(p.right() != -1 ? 1 : -1))
				.collect(Collectors.joining(Constants.FIELD_SEPARATOR.toString()));
		addParam(Command.SORT, tmp);
		return this;
	}
	
	/**
	 * Include objects where the specified field exists, regardless of the value within that field (multiple field names separated by a comma).
	 * @param args
	 * @return instance of this object
	 */
	public Query has(String...args) {
		addParam(Command.HAS, String.join(Constants.FIELD_SEPARATOR.toString(), args));
		return this;
	}
	
	/**
	 * Set whether a search should be case-sensitive, c:case=true means case-sensitive. 
	 * true is the default. 
	 * Note that using this command may slow down your queries. 
	 * If a lower case version of a field is available use that instead for faster performance.
	 * @param args
	 * @return instance of this object
	 */
	public Query case_(String...args) {
		addParam(Command.CASE, String.join(Constants.FIELD_SEPARATOR.toString(), args));
		return this;
	}
	
	/**
	 * Limit the results to at most n objects.
	 * @param n
	 * @return instance of this object
	 */
	public Query limit(int n) {
		addParam(Command.LIMIT, (n >= 0 ? Integer.toString(n) : "0"));
		return this;
	}
	
	/**
	 * Limit the results to at most (n * number of databases) objects. 
	 *  *The data type ps2/character is distributed randomly across 20 databases. 
	 * Using c:limitPerDb will have more predictable results on ps2/character than c:limit will.
	 * @param n
	 * @return instance of this object
	 */
	public Query limitPerDB(int n) {
		addParam(Command.LIMIT_PER_DB, (n >= 0 ? Integer.toString(n) : "0"));
		return this;
	}
	
	/**
	 * Start with the Nth object within the results of the query.
	 *  *Please note that c:start will have unusual behavior when querying ps2/character which is distributed randomly across 20 databases.
	 * @param n
	 * @return instance of this object
	 */
	public Query start(int n) {
		addParam(Command.START, (n >= 0 ? Integer.toString(n) : "0"));
		return this;
	}
	
	/**
	 * Include NULL values in the result. 
	 * By default this is false. For example, if the name.fr field of a vehicle is NULL the field name.fr will not be included in the response by default.
	 * Add the c:includeNull=true command if you want the value name.fr : NULL to be returned in the result.
	 *  *Please note this command will not be applied to all collections until ps2:v2.
	 * @param arg
	 * @return instance of this object
	 */
	public Query includeNULL(boolean arg) {
		addParam(Command.INCLUDE_NULL, Boolean.toString(arg));
		return this;
	}
	
	/**
	 * For internationalized strings, remove all translations except the one specified.
	 * @param arg
	 * @return instance of this object
	 */
	public Query lang(String arg) {
		addParam(Command.LANG, arg);
		return this;
	}
	
	/**
	 * Meant to replace c:resolve, useful for dynamically joining (resolving) multiple data types in one query.
	 *  See <a href="http://census.daybreakgames.com/#query-commands">Query Commands</a> for details.
	 * @param arg
	 * @return instance of this object
	 */
	public Query join(Join arg) {
		joins.add(arg);
		addParam(Command.JOIN, arg.toString());
		return this;
	}
	
	/**
	 * Useful for rearranging lists of data into trees of data.
	 *  See <a href="http://census.daybreakgames.com/#query-commands">Query Commands</a> for details.
	 * @param arg
	 * @return instance of this object
	 */
	public Query tree(Tree arg) {
		addParam(Command.TREE, arg.toString());
		return this;
	}
	
	/**
	 * Shows the time taken by the involved server-side queries and resolves.
	 * @param arg
	 * @return instance of this object
	 */
	public Query timing(boolean arg) {
		addParam(Command.TIMING, Boolean.toString(arg));
		return this;
	}
	
	/**
	 * When using a regex search (=^ or =*) c:exactMatchFirst=true will cause exact matches of the regex value to appear at the top of the result list despite the value of c:sort.
	 * @param arg
	 * @return instance of this object
	 */
	public Query exactMatchFirst(boolean arg) {
		addParam(Command.EXACT_MATCH_FIRST, Boolean.toString(arg));
		return this;
	}
	
	/**
	 * Get the distinct values of the given field. 
	 * For example to get the distinct values of ps2.item.max_stack_size use <a href="http://census.daybreakgames.com/get/ps2/item?c:distinct=max_stack_size">Item distinct</a>.
	 * Results are capped at 20,000 values.
	 * @param arg
	 * @return instance of this object
	 */
	public Query distinct(String arg) {
		addParam(Command.DISTINCT, arg);
		return this;
	}
	
	/**
	 * If true, query will be retried one time. Default value is true. If you prefer your query to fail quickly pass c:retry=false.
	 * @param arg
	 * @return instance of this object
	 */
	public Query retry(boolean arg) {
		addParam(Command.RETRY, Boolean.toString(arg));
		return this;
	}
	
	/**
	 * 
	 * @return A tree representation of a {@link Pair} of {@link Collection} and either null or the name specified by {@link Join#inject_at(String)} with {@link Query#collection} and null as root.
	 */
	public TreeNode<Pair<Collection,String>> toTree() {
		TreeNode<Pair<Collection,String>> root = new TreeNode<Pair<Collection,String>>(new Pair<>(collection,null));
		for (Join join : joins) {
			root.addNode(join.toTree());
		}
		
		return root;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Query) {
			Query c = (Query) obj;
			return c.getEndpoint().equals(endpoint)
					&& c.getCollection().equals(collection)
					&& c.getNamespace().equals(namespace)
					&& c.getService_id().equals(service_id)
					&& c.getParameters().equals(parameters);
		}
		return false;
	}
	
}
