package census.query.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import census.anatomy.Collection;
import census.query.Query;
import census.tree.Pair;
import census.tree.TreeNode;
 

public abstract class CensusCollectionImpl implements ICensusCollection {

	protected List<ICensusCollection> nestedCollections = new ArrayList<>();
	protected final Collection collection;
	protected final ObjectReader mapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.readerForUpdating(this);
	
	public CensusCollectionImpl(Collection collection) {
		this.collection = collection;
	}
	
	public Collection getCollection() {
		return collection;
	}
	
	public List<ICensusCollection> getNested() {
		return nestedCollections;
	}



	private void propagateNode(ICensusCollection col, JsonNode newJsonRoot, TreeNode<Pair<Collection, String>> newRoot) throws IllegalArgumentException, IOException {
		if (newJsonRoot.isArray()) {
			for (JsonNode elem : newJsonRoot) {
				col.parse(elem, newRoot);
			}
		} else if (newJsonRoot.isContainerNode()) {
			col.parse(newJsonRoot, newRoot);
		} else {
			throw new IllegalArgumentException("Illegal JsonNode type: " + newJsonRoot);
		}
	}

	@Override
	public final void parse(JsonNode jsonRoot, TreeNode<Pair<Collection, String>> root) throws IllegalArgumentException, IOException {
		//read values into current object	
		mapper.readValue(jsonRoot);
		//Iterate over list of joins
		for (TreeNode<Pair<Collection, String>> node : root.getChildren()) {
			ICensusCollection col = CensusCollectionFactory.create(node.getData().left());
			nestedCollections.add(col);
			String name = "";
			
			//Find name of collection if it was injected
			List<String> names = new ArrayList<>();
				
			for (Iterator<String> iter = jsonRoot.fieldNames(); iter.hasNext();) {
				String next = iter.next();
				names.add(next);
				if (node.getData().right() != null && node.getData().right().equals(next)) {
					name = next;
					break;
				}
			}
			
			//If not injected or name could not be found, filter for default pattern
			if (name.isEmpty()) {
				name = names.stream().filter(n -> n.endsWith(node.getData().left().toString().toLowerCase())).findFirst().orElse(null);
				
				//If the name could not be found again, throw exception
				if (name == null) {
					throw new IllegalArgumentException("Tree is not fully contained within JSON.");
				} else {
					propagateNode(col, jsonRoot.path(name), node);
				}
			} else {
				propagateNode(col, jsonRoot.path(name), node);
			}

		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [collection=" + collection + ", nestedCollections=" + nestedCollections + "]";
	}
	
	
	
}
