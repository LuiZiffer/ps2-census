package test;

import census.Join;
import census.Query;
import census.Tree;
import census.anatomy.Collection;
import census.anatomy.Constants;
import census.anatomy.Verb;
import census.exception.CensusException;
import census.query.dto.CensusCollectionFactory;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.internal.Character;
import census.query.dto.internal.OutfitMember;
import census.tree.Pair;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

class CensusTest {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	void testRegionCount() {
		Query q = new Query(Collection.MAP).filter("world_id", "13").filter("zone_ids", "2", "4");
		JsonNode node;
		try {

			node = q.get();
			census.query.dto.internal.Map col = (census.query.dto.internal.Map) CensusCollectionFactory
					.parseJSON(node, q).get(0);
			// System.out.println(col);
			System.out.println(col.getRegions().getRow().size());
		} catch (CensusException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	void test() {
		String mem_list = "{\"outfit_list\":[{\"outfit_id\":\"37511617366493874\",\"name\":\"Broken Arrow Company\",\"name_lower\":\"broken arrow company\",\"alias\":\"BAWC\",\"alias_lower\":\"bawc\",\"time_created\":\"1362064687\",\"time_created_date\":\"2013-02-28 15:18:07.0\",\"leader_character_id\":\"5428011263345071089\",\"member_count\":\"169\",\"members\":[{\"character_id\":\"5428016813477836529\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"SpunkMagnet\",\"first_lower\":\"spunkmagnet\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428690458375680721\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"C120P\",\"first_lower\":\"c120p\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428861139969151729\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"Terrarista\",\"first_lower\":\"terrarista\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428883591442192401\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"IvanEnchev2\",\"first_lower\":\"ivanenchev2\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428962001684326689\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"Focuslight2\",\"first_lower\":\"focuslight2\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428990295216862321\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"Droperix2137\",\"first_lower\":\"droperix2137\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428990295221766225\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"NARFMAN\",\"first_lower\":\"narfman\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428998138732138801\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"TiefenwaechterTR\",\"first_lower\":\"tiefenwaechtertr\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5428998138866702993\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"K2azEU\",\"first_lower\":\"k2azeu\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5429010062859842689\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"ZangiefTRE\",\"first_lower\":\"zangieftre\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"5429012964657314865\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"AimStArTR\",\"first_lower\":\"aimstartr\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"8274010520671372833\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"Brosef317\",\"first_lower\":\"brosef317\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"8287959095898599185\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"Fairee\",\"first_lower\":\"fairee\"},\"onlineStatus\":{\"online_status\":\"0\"}}},{\"character_id\":\"8289857657759645153\",\"rank\":\"Trial\",\"rank_ordinal\":\"8\",\"character\":{\"name\":{\"first\":\"Rainbows37\",\"first_lower\":\"rainbows37\"},\"onlineStatus\":{\"online_status\":\"0\"}}}]}],\"returned\":1}";
		try {
			JsonNode node = new ObjectMapper().readTree(mem_list);
			// Iterator<Map.Entry<String, JsonNode>> fields =
			// node.path("outfit_member_extended_list").fields();

			for (JsonNode json : node.path("outfit_list")) {
				for (Iterator<Map.Entry<String, JsonNode>> it = json.fields(); it.hasNext();) {
					Map.Entry<String, JsonNode> next = it.next();
					System.out.println("[" + next.getKey() + "] " + next.getValue());
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	void testPrintAll() {
		try (BufferedWriter out = new BufferedWriter(new FileWriter("cenus_collections_samples.txt"));
				BufferedWriter content = new BufferedWriter(new FileWriter("cenus_collections_attr.txt"))) {

			for (Collection col : Collection.values()) {
				Query q = new Query(col);
				try {
					JsonNode node = q.get();
					String tmp = "[" + col + "] " + node.toString();
					// System.out.println(tmp);
					out.append(tmp);
					out.newLine();

					content.append("[").append(col.toString()).append("]");
					content.newLine();

					for (JsonNode json : node.path(col.toString().toLowerCase() + "_list")) {
						for (Iterator<Map.Entry<String, JsonNode>> it = json.fields(); it.hasNext();) {
							Map.Entry<String, JsonNode> next = it.next();

							content.append("private String ").append(next.getKey()).append(";");
							content.newLine();

							if (next.getValue().isContainerNode()) {
								for (Iterator<Map.Entry<String, JsonNode>> it_inner = next.getValue().fields(); it_inner
										.hasNext();) {
									Map.Entry<String, JsonNode> next_inner = it_inner.next();
									content.append("__private String ").append(next_inner.getKey()).append(";");
									content.newLine();
								}
							}

						}
					}

				} catch (CensusException | IOException e) {
					try {
						System.out.println("[" + col + "] ");
						out.append("[").append(col.toString()).append("]");
						out.newLine();
						content.append("[").append(col.toString()).append("]");
						content.newLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void tmp(JsonNode node, Collection col) {
		System.out.println("[" + col + "]");
		for (JsonNode json : node.path(col.toString().toLowerCase() + "_list")) {
			for (Iterator<Map.Entry<String, JsonNode>> it = json.fields(); it.hasNext();) {
				Map.Entry<String, JsonNode> next = it.next();

				System.out.println("private String " + next.getKey() + ";");

				if (next.getValue().isContainerNode()) {
					for (Iterator<Map.Entry<String, JsonNode>> it_inner = next.getValue().fields(); it_inner
							.hasNext();) {
						Map.Entry<String, JsonNode> next_inner = it_inner.next();
						System.out.println("__private String " + next_inner.getKey() + ";");
					}
				}

			}
		}
	}

	
	void getOutfitMembers() {
		Join outfit_members = new Join(Collection.OUTFIT_MEMBER).on("outfit_id").list(1).inject_at("members")
				// .show("character_id", "rank", "rank_ordinal")
				// .terms(new Pair<String,String>("rank", "Trial"))
				.join(new Join(Collection.CHARACTER).inject_at("character")
						// .show("name")
						.hide("character_id"));
		Query q = new Query(Collection.OUTFIT).filter("alias", "BAWC").join(outfit_members);
		try {
			System.out.println(q.url(Verb.GET));
			JsonNode node = q.get();
			List<ICensusCollection> list = CensusCollectionFactory.parseJSON(node, q);

			try (BufferedWriter writer = new BufferedWriter(new FileWriter("current_members.csv"))) {
				ICensusCollection outfit = list.get(0);
				List<ICensusCollection> members = outfit.getNested();
				SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
				writer.append("Character ID").append(",");
				writer.append("Character Name").append(",");
				writer.append("Battle Rank").append(",");
				writer.append("Member Rank").append(",");
				writer.append("Member Since").append(",");
				writer.append("Last Online").append(",");
				writer.newLine();

				for (ICensusCollection col : members) {
					OutfitMember member = (OutfitMember) col;
					Character character = (Character) member.getNested().get(0);
					long tmp_date;
					System.out.println("Writing to file: " + member);
					try {
						writer.append(member.getCharacter_id()).append(",");
						writer.append(character.getName().getFirst()).append(",");
						if (character.getPrestige_level().equals("1")) {
							writer.append("*");
						}
						writer.append(character.getBattle_rank().getValue()).append(",");
						writer.append(member.getRank()).append(",");
						
						tmp_date = Long.parseLong(member.getMember_since())*1000;
						writer.append(sdf.format(new Date(tmp_date))).append(",");
						
						tmp_date = Long.parseLong(character.getTimes().getLast_login())*1000;
						writer.append(sdf.format(new Date(tmp_date))).append(",");
						writer.newLine();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				writer.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (CensusException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGet() {
		Join outer = new Join(Collection.OUTFIT_MEMBER).on("outfit_id").list(1).inject_at("members")
				// .show("character_id", "rank", "rank_ordinal")
				.terms(new Pair<>("rank", "Trial"))
				.join(new Join(Collection.CHARACTER).inject_at("character")
						// .show("name")
						.join(new Join(Collection.CHARACTERS_ONLINE_STATUS)
								// .inject_at("onlineStatus")
								.hide("character_id")));

		Query c2 = new Query(Collection.EVENT).filter("type", "DEATH");
		Query c3 = new Query(Collection.SINGLE_CHARACTER_BY_ID).filter("character_id",
				"5428013610477389601");
		Query c4 = new Query(Collection.CHARACTERS_LEADERBOARD).filter("character_id",
				"5428013610477389601");

		// System.out.println(c1.toTree().generateConsoleView("_"));
		System.out.println(c2.toTree().generateConsoleView("_"));
		// System.out.println(c1.url(Verb.GET));
		System.out.println(c2.url(Verb.COUNT));

		try {
			// JsonNode node1 = c1.get();
			JsonNode node2 = c2.get();
			// System.out.println(node2);

			// System.out.println(c3.get());
			// System.out.println(c4.get());
			// System.out.println(c5.url(Verb.GET));

			// tmp(node2, c2.getCollection());
			// tmp(c3.get(), c3.getCollection());
			// tmp(c4.get(), c4.getCollection());

			// System.out.println(node1);
			// List<ICensusCollection> col1 = CensusCollectionFactory.parseJSON(node1, c1);
			// System.out.println(col1);

			List<ICensusCollection> col2 = CensusCollectionFactory.parseJSON(node2, c2);
			System.out.println(col2);

		} catch (CensusException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testItemCol() {
		Query query = new Query(Collection.ITEM).tree(new Tree("name.en").prefix("en_name_"));
		try {
			System.out.println(query.toTree().generateConsoleView("_"));
			JsonNode node = query.get();
			System.out.println(node);
			System.out.println(CensusCollectionFactory.parseJSON(node, query));
		} catch (CensusException | IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Test
	void testQuery() {
		Map<Collection, Exception> retrieved = new HashMap<>();
		for (Collection col : Collection.values()) {
			if (col == Collection.NONE || col == Collection.GAME_SERVER_STATUS) continue;
			//FIXME: replace example service id with personal one, or this will not work
			Query q = new Query(col, Constants.EXAMPLE_SERVICE_ID.toString());
			try {
				long t1 = System.nanoTime();
				q.get();
				long t2 = System.nanoTime();
				logger.debug("[" + col + "] response reeived in " + (t2 - t1) / 1e6d + "ms");
				retrieved.put(col, null);
			} catch (Exception e) {
				logger.debug("[" + col + "] could not be retrieved");
				retrieved.put(col, e);
			}
		}
		logger.debug("" + retrieved.values().stream().filter(Objects::isNull).count() + " successful retrievals " +
				"and " + retrieved.values().stream().filter(Objects::nonNull).count() + " failures");
	}

	@Test
	void testCesusSanctuary(){
		Query census = new Query(Collection.MAP_REGION, Constants.EXAMPLE_SERVICE_ID.toString());
		census.filter("zone_id", "344");

		Query sanctuary = new Query(census);
		sanctuary.setEndpoint("https://census.lithafalcon.cc");

		try {
			JsonNode censusNode = census.get();
			System.out.println(censusNode);
			List<ICensusCollection> censusCol = census.getAndParse();
			System.out.println(censusCol);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			JsonNode sanctuaryNode = sanctuary.get();
			System.out.println(sanctuaryNode);
			List<ICensusCollection> sanctuaryCol = sanctuary.getAndParse();
			System.out.println(sanctuaryCol);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
