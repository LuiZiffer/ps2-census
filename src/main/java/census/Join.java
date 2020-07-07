package census;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import census.anatomy.Collection;
import census.anatomy.Constants;
import census.anatomy.JoinKey;
import census.tree.Pair;
import census.tree.TreeNode;

public class Join {
	
	private Collection collection;
	private List<Join> nestedJoins = new ArrayList<>();
	private List<Pair<JoinKey,String>> arguments = new ArrayList<>();
	
	/**
	 * Instantiates the {@link Join} with a {@link Collection}
	 * @param collection The collection name to join to (type: is optional on this one).
	 */
	public Join(Collection collection) {
		this.collection = collection;
	}

	
	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public List<Join> getNestedJoins() {
		return nestedJoins;
	}

	public void setNestedJoins(List<Join> nestedJoins) {
		this.nestedJoins = nestedJoins;
	}

	public List<Pair<JoinKey,String>> getArguments() {
		return arguments;
	}

	public void setArguments(List<Pair<JoinKey,String>> arguments) {
		this.arguments = arguments;
	}
	
	private boolean containsKey(JoinKey key) {
		return arguments.stream().map(p -> p.left()).filter(k -> k.equals(key)).findAny().isPresent();
	}
	
	private void addArgument(JoinKey key, String argument) {
		if (key != null && argument != null && !argument.isEmpty() && !containsKey(key)) {
			arguments.add(new Pair<>(key,argument));
		}
	}
	
	
	/**
	 * Add nested {@link Join}s to this object
	 * @param join
	 * @return instance of this object
	 */
	public Join join(Join... join) {
		if (join != null) {
			for (Join j : join) {
				if (!nestedJoins.contains(j)) {
					nestedJoins.add(j);
				}
			}
		}
		return this;
	}
	
	/**
	 * The field on this type to join on, i.e. item_id. Will default to {this_type}_id or {other_type}_id if not provided.
	 * @param argument 
	 * @return instance of this object
	 */
	public Join on(String argument) {
		if (argument == null || argument.isEmpty()) return this;
		addArgument(JoinKey.ON, argument);
		return this;
	}

	/**
	 * The field on the joined type to join to, i.e. attachment_item_id. Will default to on if on is provide, otherwise will default to {this_type}_id or {other_type}_id if not provided.
	 * @param argument 
	 * @return instance of this object
	 */
	public Join to(String argument) {
		if (argument == null || argument.isEmpty()) return this;
		addArgument(JoinKey.TO, argument);
		return this;
	}
	
	/**
	 * 0 if joined data is not a list, 1 if it is a list. Defaults to 0- not a list.
	 * @param argument
	 * @return instance of this object
	 */
	public Join list(int argument) {
		int tmp = argument != 1 ? 0 : argument;
		addArgument(JoinKey.LIST, Integer.toString(tmp));
		return this;
	}
	
	/**
	 * Single quote (top comma) delimited list of fields to show
	 * @param arguments
	 * @return instance of this object
	 */
	public Join show(String... arguments) {
		if (arguments == null || arguments.length <= 0) return this;
		String tmp = String.join(Constants.JOIN_VALUE_DELIMITER.toString(), (CharSequence[]) arguments);
		addArgument(JoinKey.SHOW, tmp);
		return this;
	}
	
	/**
	 * Single quote (top comma) delimited list of fields to hide
	 * @param arguments
	 * @return instance of this object
	 */
	public Join hide(String... arguments) {
		if (arguments == null || arguments.length <= 0) return this;
		String tmp = String.join(Constants.JOIN_VALUE_DELIMITER.toString(), (CharSequence[]) arguments);
		addArgument(JoinKey.HIDE, tmp);
		return this;
	}
	
	/**
	 * The field name where the joined data should be injected into the returned document.
	 * @param argument
	 * @return instance of this object
	 */
	public Join inject_at(String argument) {
		if (argument == null || argument.isEmpty()) return this;
		addArgument(JoinKey.INJECT_AT, argument);
		return this;
	}
	
	/**
	 * Filter terms for the join query. Multiple expressions can be divided by the ' character.
	 *  For example: <i>http://census.daybreakgames.com/get/ps2/item_attachment?c:limit=100&amp;c:join=item^terms:faction_id=1'skill_set_id=129</i>.
	 *	Unfortunately, the terms functionality will not work on all data types. If the data type can not be filtered by a field directly, terms will not function either. 
	 *	For example, ps2/characters_online_status can only be queried by character_id so joining to it and using terms online_status will have no effect. 
	 * @param arguments
	 * @return instance of this object
	 */
	public Join terms(Pair<String,String>[] arguments) {
		if (arguments == null || arguments.length <= 0) return this;
		String tmp = Arrays.asList(arguments).stream()
				.map(e -> e.left() + "=" + e.right())
				.collect(Collectors.joining(Constants.JOIN_VALUE_DELIMITER.toString()));
		addArgument(JoinKey.TERMS, tmp);
		return this;
	}
	
	/**
	 * Filter terms for the join query. Multiple expressions can be divided by the ' character.
	 *  For example: <i>http://census.daybreakgames.com/get/ps2/item_attachment?c:limit=100&amp;c:join=item^terms:faction_id=1'skill_set_id=129</i>.
	 *	Unfortunately, the terms functionality will not work on all data types. If the data type can not be filtered by a field directly, terms will not function either. 
	 *	For example, ps2/characters_online_status can only be queried by character_id so joining to it and using terms online_status will have no effect. 
	 * @param argument
	 * @return instance of this object
	 */
	public Join terms(Pair<String,String> argument) {
		addArgument(JoinKey.TERMS, argument.left() + "=" + argument.right());
		return this;
	}
	
	/**
	 * 1 if you wish to do an outer join (include non-matches), 0 if you wish to do an inner join (exclude non-matches). 
	 * Defaults to 1- do an outer join, include non-matches.
	 * @param argument
	 * @return instance of this object
	 */
	public Join outer(int argument) {
		int tmp = argument != 1 ? 0 : argument;
		addArgument(JoinKey.OUTER, Integer.toString(tmp));
		return this;
	}
	
	/**
	 * 
	 * @return A tree representation of a {@link Pair} of {@link Collection} and either null or the name specified by {@link Join#inject_at(String)}.
	 */
	public TreeNode<Pair<Collection,String>> toTree() {
		Pair<Collection,String> data = new Pair<Collection, String>(collection, null);
		TreeNode<Pair<Collection,String>> node = new TreeNode<Pair<Collection,String>>(data);
		
		Pair<JoinKey,String> p = arguments.stream().filter(pair -> pair.left() == JoinKey.INJECT_AT).findAny().orElse(null);
		if (p != null) {
			data.setRight(p.right());
		}
		for (Join join : nestedJoins) {
			if (join == null) continue;
			node.addNode(join.toTree());
		}
		return node;
	}
	
	@Override
	public String toString() {
		String tmp = collection.toString() + Constants.JOIN_ITEM_DELIMITER;
		tmp += arguments.stream()
				.map(p -> p.left() + ":" + p.right())
				.collect(Collectors.joining(Constants.JOIN_ITEM_DELIMITER.toString()));
		if (!nestedJoins.isEmpty()) {
			tmp += "(" + nestedJoins.stream().map(Object::toString).collect(Collectors.joining(",")) + ")";
		}
		return tmp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Join other = (Join) obj;
		if (collection != other.collection)
			return false;
		return true;
	}
	
}
