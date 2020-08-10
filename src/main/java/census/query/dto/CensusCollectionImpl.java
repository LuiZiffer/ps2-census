package census.query.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import census.anatomy.Collection;
import census.tree.Pair;
import census.tree.TreeNode;
 

public abstract class CensusCollectionImpl implements ICensusCollection {

	protected List<ICensusCollection> nestedCollections = new ArrayList<>();
	protected final Collection collection;
	protected final ObjectReader mapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
			.readerForUpdating(this);
	
	@JsonIgnore
	protected Map<String, Object> properties = new HashMap<>();
	
	@JsonAnyGetter
	public Map<String, Object> getProperties() {
		return properties;
	}

	@JsonAnySetter
	public void setProperties(String key, Object value) {
		this.properties.put(key, value);
	}
	
	
	public CensusCollectionImpl(Collection collection) {
		this.collection = collection;
	}
	
	public Collection getCollection() {
		return collection;
	}
	
	public List<ICensusCollection> getNested() {
		return nestedCollections;
	}



	private void propagateNode(JsonNode newJsonRoot, TreeNode<Pair<Collection, String>> newRoot) throws IllegalArgumentException, IOException {
		if (newJsonRoot.isArray()) {
			for (JsonNode elem : newJsonRoot) {
				ICensusCollection new_col = CensusCollectionFactory.create(newRoot.getData().getLeft());
				nestedCollections.add(new_col);
				new_col.parse(elem, newRoot, false);
			}
		} else if (newJsonRoot.isContainerNode()) {
			ICensusCollection new_col = CensusCollectionFactory.create(newRoot.getData().getLeft());
			nestedCollections.add(new_col);
			new_col.parse(newJsonRoot, newRoot, false);
		} else {
			throw new IllegalArgumentException("Illegal JsonNode type: " + newJsonRoot);
		}
	}

	@Override
	public final void parse(JsonNode jsonRoot, TreeNode<Pair<Collection, String>> root, boolean fromTree) throws IllegalArgumentException, IOException {
		//read values into current object	
		JsonNode localNode = jsonRoot;
		if (fromTree) {
			String tmp = localNode.fieldNames().next();
			localNode = localNode.path(tmp);
		}
		mapper.readValue(localNode);
		
		//Iterate over list of joins
		for (TreeNode<Pair<Collection, String>> node : root.getChildren()) {
			//ICensusCollection col = CensusCollectionFactory.create(node.getData().left());
			//nestedCollections.add(col);
			String name = "";
			
			//Find name of collection if it was injected
			List<String> names = new ArrayList<>();
				
			for (Iterator<String> iter = localNode.fieldNames(); iter.hasNext();) {
				String next = iter.next();
				names.add(next);
				if (node.getData().getRight() != null && node.getData().getRight().equals(next)) {
					name = next;
					break;
				}
			}

			//If not injected or name could not be found, filter for default pattern
			if (name.isEmpty()) {
				name = names.stream().filter(n -> n.endsWith(node.getData().getLeft().toString().toLowerCase())).findFirst().orElse(null);
				
				//If the name could not be found again, throw exception
				if (name != null) {
					propagateNode(localNode.path(name), node);
				}
			} else {
				propagateNode(localNode.path(name), node);
			}

		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [collection=" + collection + ", nestedCollections=" + nestedCollections + "]";
	}
	
	
	
}
