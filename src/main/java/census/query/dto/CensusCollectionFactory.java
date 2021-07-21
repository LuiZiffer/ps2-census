package census.query.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import census.Query;
import census.anatomy.Collection;
import census.anatomy.Command;
import census.query.dto.internal.*;
import census.query.dto.internal.Character;
import census.query.dto.internal.CharacterName;

public class CensusCollectionFactory {

	/**
	 * Creates a class corresponding to the passed {@link Collection}
	 * @param collection
	 * @return the created class
	 */
	public static ICensusCollection create(Collection collection) {
		ICensusCollection c = null;
		switch(collection) {
		case GAME_SERVER_STATUS:
			c = new GameServerStatus();
			break;
		case ABILITY:
			c = new Ability();
			break;
		case ABILITY_TYPE:
			c = new AbilityType();
			break;
		case ACHIEVEMENT:
			c = new Achievement();
			break;
		case ARMOR_FACING:
			c = new ArmorFacing();
			break;
		case ARMOR_INFO:
			c = new ArmorInfo();
			break;
		case CHARACTER:
			c = new Character();
			break;
		case CHARACTERS_ACHIEVEMENT:
			c = new CharactersAchievment();
			break;
		case CHARACTERS_CURRENCY:
			c = new CharactersCurrency();
			break;
		case CHARACTERS_DIRECTIVE:
			c = new CharactersDirective();
			break;
		case CHARACTERS_DIRECTIVE_OBJECTIVE:
			c = new CharactersDirectiveObjective();
			break;
		case CHARACTERS_DIRECTIVE_TIER:
			c = new CharactersDirectiveTier();
			break;
		case CHARACTERS_DIRECTIVE_TREE:
			c = new CharactersDirectiveTree();
			break;
		case CHARACTERS_EVENT:
			c = new CharactersEvent();
			break;
		case CHARACTERS_EVENT_GROUPED:
			c = new CharactersEventGrouped();
			break;
		case CHARACTERS_FRIEND:
			c = new CharactersFriend();
			break;
		case CHARACTERS_ITEM:
			c = new CharactersItem();
			break;
		case CHARACTERS_LEADERBOARD:
			c = new CharactersLeaderboard();
			break;
		case CHARACTERS_ONLINE_STATUS:
			c = new CharactersOnlineStatus();
			break;
		case CHARACTERS_SKILL:
			c = new CharactersSkill();
			break;
		case CHARACTERS_STAT:
			c = new CharactersStat();
			break;
		case CHARACTERS_STAT_BY_FACTION:
			c = new CharactersStatByFaction();
			break;
		case CHARACTERS_STAT_HISTORY:
			c = new CharactersStatHistory();
			break;
		case CHARACTERS_WEAPON_STAT:
			c = new CharactersWeaponStat();
			break;
		case CHARACTERS_WEAPON_STAT_BY_FACTION:
			c = new CharactersWeaponStatByFaction();
			break;
		case CHARACTERS_WORLD:
			c = new CharactersWorld();
			break;
		case CHARACTER_NAME:
			c = new CharacterName();
			break;
		case CURRENCY:
			c = new Currency();
			break;
		case DIRECTIVE:
			c = new Directive();
			break;
		case DIRECTIVE_TIER:
			c = new DirectiveTier();
			break;
		case DIRECTIVE_TREE:
			c = new DirectiveTree();
			break;
		case DIRECTIVE_TREE_CATEGORY:
			c = new DirectiveTreeCategory();
			break;
		case EFFECT:
			c = new Effect();
			break;
		case EFFECT_TYPE:
			c = new EffectType();
			break;
		case EMPIRE_SCORES:
			c = new EmpireScores();
			break;
		case EVENT:
			c = new Event();
			break;
		case EXPERIENCE:
			c = new Experience();
			break;
		case EXPERIENCE_RANK:
			c = new ExperienceRank();
			break;
		case FACILITY_LINK:
			c = new FacilityLink();
			break;
		case FACILITY_TYPE:
			c = new FacilityType();
			break;
		case FACTION:
			c = new Faction();
			break;
		case FIRE_GROUP:
			c = new FireGroup();
			break;
		case FIRE_GROUP_TO_FIRE_MODE:
			c = new FireGroupToFireMode();
			break;
		case FIRE_MODE:
			c = new FireMode();
			break;
		case FIRE_MODE_2:
			c = new FireMode2();
			break;
		case FIRE_MODE_TO_PROJECTILE:
			c = new FireModeToProjectile();
			break;
		case FIRE_MODE_TYPE:
			c = new FireModeType();
			break;
		case IMAGE:
			c = new Image();
			break;
		case IMAGE_SET:
			c = new ImageSet();
			break;
		case IMAGE_SET_DEFAULT:
			c = new ImageSetDefault();
			break;
		case ITEM:
			c = new Item();
			break;
		case ITEM_ATTACHMENT:
			c = new ItemAttachment();
			break;
		case ITEM_CATEGORY:
			c = new ItemCategory();
			break;
		case ITEM_PROFILE:
			c = new ItemProfile();
			break;
		case ITEM_TO_WEAPON:
			c = new ItemToWeapon();
			break;
		case ITEM_TYPE:
			c = new ItemType();
			break;
		case LEADERBOARD:
			c = new Leaderboard();
			break;
		case LOADOUT:
			c = new Loadout();
			break;
		case MAP:
			c = new Map();
			break;
		case MAP_HEX:
			c = new MapHex();
			break;
		case MAP_REGION:
			c = new MapRegion();
			break;
		case MARKETING_BUNDLE:
			c = new MarketingBundle();
			break;
		case MARKETING_BUNDLE_ITEM:
			c = new MarketingBundleItem();
			break;
		case MARKETING_BUNDLE_WITH_ONE_ITEM:
			c = new MarketingBundleWithOneItem();
			break;
		case METAGAME_EVENT:
			c = new MetagameEvent();
			break;
		case METAGAME_EVENT_STATE:
			c = new MetagameEventState();
			break;
		case OBJECTIVE:
			c = new Objective();
			break;
		case OBJECTIVE_SET_TO_OBJECTIVE:
			c = new ObjectiveSetToObjective();
			break;
		case OBJECTIVE_TYPE:
			c = new ObjectiveType();
			break;
		case OUTFIT:
			c = new Outfit();
			break;
		case OUTFIT_MEMBER:
			c = new OutfitMember();
			break;
		case OUTFIT_MEMBER_EXTENDED:
			c = new OutfitMemberExtended();
			break;
		case OUTFIT_RANK:
			c = new OutfitRank();
			break;
		case PLAYER_STATE:
			c = new PlayerState();
			break;
		case PLAYER_STATE_GROUP:
			c = new PlayerStateGroup();
			break;
		case PLAYER_STATE_GROUP_2:
			c = new PlayerStateGroup2();
			break;
		case PROFILE:
			c = new Profile();
			break;
		case PROFILE_2:
			c = new Profile2();
			break;
		case PROFILE_ARMOR_MAP:
			c = new ProfileArmorMap();
			break;
		case PROFILE_RESIST_MAP:
			c = new ProfileResistMap();
			break;
		case PROJECTILE:
			c = new Projectile();
			break;
		case PROJECTILE_FLIGHT_TYPE:
			c = new ProjectileFlightType();
			break;
		case REGION:
			c = new Region();
			break;
		case RESIST_INFO:
			c = new ResistInfo();
			break;
		case RESIST_TYPE:
			c = new ResistType();
			break;
		case RESOURCE_TYPE:
			c = new ResourceType();
			break;
		case REWARD:
			c = new Reward();
			break;
		case REWARD_GROUP_TO_REWARD:
			c = new RewardGroupToReward();
			break;
		case REWARD_SET_TO_REWARD_GROUP:
			c = new RewardSetToRewardGroup();
			break;
		case REWARD_TYPE:
			c = new RewardType();
			break;
		case SINGLE_CHARACTER_BY_ID:
			c = new SingleCharacterById();
			break;
		case SKILL:
			c = new Skill();
			break;
		case SKILL_CATEGORY:
			c = new SkillCategory();
			break;
		case SKILL_LINE:
			c = new SkillLine();
			break;
		case SKILL_SET:
			c = new SkillSet();
			break;
		case TARGET_TYPE:
			c = new TargetType();
			break;
		case TITLE:
			c = new Title();
			break;
		case VEHICLE:
			c = new Vehicle();
			break;
		case VEHICLE_ATTACHMENT:
			c = new VehicleAttachment();
			break;
		case VEHICLE_FACTION:
			c = new VehicleFaction();
			break;
		case VEHICLE_SKILL_SET:
			c = new VehicleSkillSet();
			break;
		case WEAPON:
			c = new Weapon();
			break;
		case WEAPON_AMMO_SLOT:
			c = new WeaponAmmoSlot();
			break;
		case WEAPON_DATASHEET:
			c = new WeaponDatasheet();
			break;
		case WEAPON_TO_ATTACHMENT:
			c = new WeaponToAttachment();
			break;
		case WEAPON_TO_FIRE_GROUP:
			c = new WeaponToFireGroup();
			break;
		case WORLD:
			c = new World();
			break;
		case WORLD_EVENT:
			c = new WorldEvent();
			break;
		case WORLD_STAT_HISTORY:
			c = new WorldStatHistory();
			break;
		case ZONE:
			c = new Zone();
			break;
		case ZONE_EFFECT:
			c = new ZoneEffect();
			break;
		case ZONE_EFFECT_TYPE:
			c = new ZoneEffectType();
			break;
		default:
			break;
		
		}
		return c;
	}

	/**
	 * Maps the JSON object response from the census api into java classes.
	 * Parsing with the collection "NONE" is not allowed.
	 * @param jsonResponse The JSON object received from census
	 * @param query The query used to build the HTTP request
	 * @return list of classes corresponding to the JSON object
	 * @throws IllegalArgumentException when a JSON object other than Array or Container is received, or the collection is "NONE"
	 * @throws IOException when an error occurs while reading the JSON object
	 */
	public static final List<ICensusCollection> parseJSON(JsonNode jsonResponse, final Query query) throws IllegalArgumentException, IOException {
		if (query.getCollection() == Collection.NONE)
			throw new IllegalArgumentException("Parsing a JSON object from collection \"NONE\" is not allowed");
		List<ICensusCollection> list = new ArrayList<>();
		for (JsonNode node : jsonResponse.path(query.getCollection().toString().toLowerCase() + "_list")) {
			ICensusCollection root = CensusCollectionFactory.create(query.getCollection());
			list.add(root);
			root.parse(node, query.toTree(), query.containsParamKey(Command.TREE));
		}
		return list;
	}

}
