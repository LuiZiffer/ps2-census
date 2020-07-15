import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.internal.*;
import census.query.dto.internal.Character;
import census.query.dto.internal.Map;
import census.tree.Pair;
import census.anatomy.*;
import census.exception.CensusInvalidSearchTermException;

public final class QueryExamples {
	
	public static final String serviceId = "example";

	private QueryExamples() {}

	public static int getRegionCount(String worldId, String zoneId) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.MAP, serviceId).filter("world_id", worldId).filter("zone_ids", zoneId);
		Map col = (Map) q.getAndParse().get(0);
		return col.getRegions().getRow().size();
	}

	public static Character getPlayerByName(String name) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("name.first_lower", name.toLowerCase());
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return (Character) list.get(0);
	}

	public static Character getPlayerById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("character_id", id);
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return (Character) list.get(0);
	}

	public static List<Character> getPlayersById(String... ids) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("character_id", ids).limit(ids.length);
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.stream().map(m -> (Character) m).collect(Collectors.toList());
	}

	public static List<OutfitMemberExtended> getMemberDataById(String... ids)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER_EXTENDED, serviceId).filter("character_id", ids).limit(ids.length);
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.stream().map(m -> (OutfitMemberExtended) m).collect(Collectors.toList());
	}

	public static String getPlayerNameById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("character_id", id).show("name.first");
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return ((Character) list.get(0)).getName().getFirst();
	}

	public static List<String> getPlayerIdsByNames(String... names)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).show("character_id").limit(names.length);
		for (String name : names) {
			q.filter("name.first_lower", name.toLowerCase());
		}
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.stream().map(m -> ((Character) m).getCharacter_id()).collect(Collectors.toList());
	}

	public static String getPlayerIdByName(String name) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("name.first_lower", name.toLowerCase())
				.show("character_id");
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return ((Character) list.get(0)).getCharacter_id();
	}

	public static Outfit getOutfitByTag(String tag) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT, serviceId).filter("alias_lower", tag.toLowerCase());
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return (Outfit) list.get(0);
	}

	public static Outfit getOutfitById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT, serviceId).filter("outfit_id", id);
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return (Outfit) list.get(0);
	}

	public static String getOutfitIdByTag(String tag) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT, serviceId).filter("alias_lower", tag.toLowerCase()).show("outfit_id");
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return ((Outfit) list.get(0)).getOutfit_id();
	}

	public static long getOutfitMemberCountByTag(String tag) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER_EXTENDED, serviceId).filter("alias_lower", tag.toLowerCase());
		return q.count();
	}

	public static long getOutfitMemberCountById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER, serviceId).filter("outfit_id", id);
		return q.count();
	}

	public static String getOutfitMemberRankById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER, serviceId).filter("character_id", id).show("rank");
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return ((OutfitMember) list.get(0)).getRank();
	}

	public static String getOutfitMemberRankByName(String name) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("name.first_lower", name)
				.join(new Join(Collection.OUTFIT_MEMBER).show("rank"));
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return ((OutfitMember) list.get(0)).getRank();
	}

	public static String getOutfitTagOfMember(String name) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("name.first_lower", name.toLowerCase())
				.show("character_id")
				.join(new Join(Collection.OUTFIT_MEMBER_EXTENDED).on("character_id").show("alias"));
		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return ((OutfitMemberExtended) list.get(0)).getAlias();
	}

	public static List<OutfitMember> getOutfitMembersByTag(String outfit_tag, String outfit_rank)
			throws CensusInvalidSearchTermException, IOException {
		Join outfit_members = new Join(Collection.OUTFIT_MEMBER).on("outfit_id").list(1);
		if (outfit_rank != null && !outfit_rank.isEmpty()) {
			outfit_members.terms(new Pair<String, String>("rank", outfit_rank));
		}
		Query q = new Query(Collection.OUTFIT, serviceId).filter("alias_lower", outfit_tag).show("outfit_id")
				.join(outfit_members);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return list.stream().map(m -> ((OutfitMember) m)).collect(Collectors.toList());
	}

	public static List<OutfitMember> getOutfitMembersById(String outfit_id, String outfit_rank)
			throws CensusInvalidSearchTermException, IOException {
		Join outfit_members = new Join(Collection.OUTFIT_MEMBER).on("outfit_id").list(1);
		if (outfit_rank != null && !outfit_rank.isEmpty()) {
			outfit_members.terms(new Pair<String, String>("rank", outfit_rank));
		}
		Query q = new Query(Collection.OUTFIT, serviceId).filter("outfit_id", outfit_id).show("outfit_id")
				.join(outfit_members);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return list.stream().map(m -> ((OutfitMember) m)).collect(Collectors.toList());
	}

	public static List<String> getMemberIdsByOutfitId(String outfit_id, String outfit_rank)
			throws CensusInvalidSearchTermException, IOException {
		Join outfit_members = new Join(Collection.OUTFIT_MEMBER).on("outfit_id").list(1).show("character_id");
		if (outfit_rank != null && !outfit_rank.isEmpty()) {
			outfit_members.terms(new Pair<String, String>("rank", outfit_rank));
		}
		Query q = new Query(Collection.OUTFIT, serviceId).filter("outfit_id", outfit_id).show("outfit_id")
				.join(outfit_members);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return list.stream().map(m -> ((OutfitMember) m).getCharacter_id()).collect(Collectors.toList());
	}

	public static census.enums.World getOutfitWorldById(String id)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER, serviceId).filter("outfit_id", id).show("character_id")
				.join(new Join(Collection.CHARACTERS_WORLD).on("character_id").show("world_id"));

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return census.enums.World.findWorld(Integer.parseInt(((CharactersWorld) list.get(0)).getWorld_id()));
	}

	public static census.enums.Faction getCharacterFactionByName(String name)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("name.first_lower", name.toLowerCase())
				.show("faction_id");

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		return census.enums.Faction.findFaction(Integer.parseInt(((Character) list.get(0)).getFaction_id()));
	}

	public static census.enums.Faction getCharacterFactionById(String id)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.CHARACTER, serviceId).filter("character_id", id).show("faction_id");

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return census.enums.Faction.findFaction(Integer.parseInt(((Character) list.get(0)).getFaction_id()));
	}

	public static census.enums.Faction getOutfitFactionByTag(String tag)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER_EXTENDED, serviceId).filter("alias_lower", tag.toLowerCase())
				.show("character_id").join(new Join(Collection.CHARACTER).on("character_id").show("faction_id"));

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return census.enums.Faction.findFaction(Integer.parseInt(((Character) list.get(0)).getFaction_id()));
	}

	public static census.enums.Faction getOutfitFactionById(String id)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER_EXTENDED, serviceId).filter("outfit_id", id).show("character_id")
				.join(new Join(Collection.CHARACTER).on("character_id").show("faction_id"));

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}
		list = ((CensusCollectionImpl) list.get(0)).getNested();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return census.enums.Faction.findFaction(Integer.parseInt(((Character) list.get(0)).getFaction_id()));
	}

	public static OutfitMemberExtended getOutfitMemberById(String id)
			throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.OUTFIT_MEMBER_EXTENDED, serviceId).filter("character_id", id);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return (OutfitMemberExtended) list.get(0);
	}

	public static MapRegion getRegionByFacilityId(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.MAP_REGION, serviceId).filter("facility_id", id);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return (MapRegion) list.get(0);
	}

	public static MetagameEvent getAlertById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.METAGAME_EVENT, serviceId).filter("metagame_event_id", id);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return (MetagameEvent) list.get(0);
	}

	public static MetagameEventState getAlertStateById(String id) throws CensusInvalidSearchTermException, IOException {
		Query q = new Query(Collection.METAGAME_EVENT_STATE, serviceId).filter("metagame_event_state_id", id);

		List<ICensusCollection> list = q.getAndParse();

		if (list == null || list.isEmpty()) {
			return null;
		}

		return (MetagameEventState) list.get(0);
	}

}
