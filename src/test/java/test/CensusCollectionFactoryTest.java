package test;

import census.Query;
import census.exception.CensusException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CensusCollectionFactoryTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void testCreate() {
		for(Collection collection : Collection.values()) {
			logger.info("Testing Collection: " + collection);
			assertEquals(collection, CensusCollectionFactory.create(collection).getCollection());
		}
	}

	@Test
	void testCompareCollectionLists() {
		Map<String, Boolean> collection = new HashMap<>();
		Query q = new Query(Collection.NONE);
		try {
			JsonNode root = q.get();
			if (root.get("datatype_list").isArray()) {
				root.get("datatype_list").forEach(node -> {
					logger.debug("[" + node.get("name").asText() + "] " +
							(Collection.findByName(node.get("name").asText()) != null));
					collection.put(node.get("name").asText(),
							(Boolean) (Collection.findByName(node.get("name").asText()) != null));
				});
			}
			assertFalse(collection.containsValue((Boolean) false), "Some collections are missing");
		} catch (Exception e) {
			fail(e);
		}
	}
}
