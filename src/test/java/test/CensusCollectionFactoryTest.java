package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionFactory;

class CensusCollectionFactoryTest {
	
	@Test
	void testCreate() {
		for(Collection collection : Collection.values()) {
			System.out.println("Testing Collection: " + collection);
			assertEquals(collection, CensusCollectionFactory.create(collection).getCollection());
		}
	}

}
