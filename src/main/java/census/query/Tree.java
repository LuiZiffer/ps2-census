package census.query;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import census.anatomy.Constants;
import census.anatomy.TreeKey;

public class Tree {
	private Map<TreeKey,String> parameters = new HashMap<>();
	
	/**
	 * Instantiates Tree with a {@link TreeKey.FIELD}
	 * @param field The field to remove and use as in the data structure, or tree.
	 */
	public Tree(String field) {
		parameters.put(TreeKey.FIELD, field);
	}
	

	public Map<TreeKey, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<TreeKey, String> parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tree) {
			return ((Tree) obj).getParameters().equals(parameters);
		}
		return false;
	}

	@Override
	public String toString() {
		return parameters.entrySet().stream()
				.map(p -> p.getKey() + ":" + p.getValue())
				.collect(Collectors.joining(Constants.TREE_ITEM_DELIMITER.toString()));
	}
	
	
	private void addParam(TreeKey key, String...args) {
		parameters.put(key, String.join(Constants.TREE_VALUE_DELIMITER.toString(), args));
	}
	
	
	/**
	 * 0 if tree data is not a list, 1 if it is a list. Defaults to 0.
	 * @param arg
	 * @return instance of this object
	 */
	public Tree list(int arg) {
		addParam(TreeKey.LIST, (arg != 0 ? "1" : "0"));
		return this;
	}
	
	/**
	 * A prefix to add to the field value to make it more readable.
	 * For example, if the field is "faction_id" and prefix is "f_", path will be f_1, f_2, f_3 etc.
	 * @param arg
	 * @return instance of this object
	 */
	public Tree prefix(String arg) {
		addParam(TreeKey.PREFIX, arg);
		return this;
	}
	
	/**
	 * Used to tell the tree where to start. By default, the list of objects at the root will be formatted as a tree.
	 * @param arg
	 * @return instance of this object
	 */
	public Tree start(String arg) {
		addParam(TreeKey.START, arg);
		return this;
	}
	
}
