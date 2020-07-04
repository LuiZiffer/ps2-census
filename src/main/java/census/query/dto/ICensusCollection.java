package census.query.dto;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import census.anatomy.Collection;
import census.tree.Pair;
import census.tree.TreeNode;

public interface ICensusCollection {

	public Collection getCollection();
	
	void parse(JsonNode json, TreeNode<Pair<Collection,String>> resolveTree) throws IllegalArgumentException, IOException;
}
