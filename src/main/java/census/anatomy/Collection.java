package census.anatomy;

import census.enums.World;
import com.fasterxml.jackson.databind.JsonNode;

public enum Collection {
    /**
     * This collection does not allow filtering or parsing. It is used to retrieve all available collections.
     */
    NONE("NONE"),

    /**
     * This collection can only be used in conjunction with namespace "global"
     */
    GAME_SERVER_STATUS("game_server_status"),
    ABILITY("ability"),
    ABILITY_TYPE("ability_type"),
    ACHIEVEMENT("achievement"),
    ARMOR_FACING("armor_facing"),
    ARMOR_INFO("armor_info"),
    CHARACTER("character"),
    CHARACTERS_ACHIEVEMENT("characters_achievement"),
    CHARACTERS_CURRENCY("characters_currency"),
    CHARACTERS_DIRECTIVE("characters_directive"),
    CHARACTERS_DIRECTIVE_OBJECTIVE("characters_directive_objective"),
    CHARACTERS_DIRECTIVE_TIER("characters_directive_tier"),
    CHARACTERS_DIRECTIVE_TREE("characters_directive_tree"),
    CHARACTERS_EVENT("characters_event"),
    CHARACTERS_EVENT_GROUPED("characters_event_grouped"),
    CHARACTERS_FRIEND("characters_friend"),
    CHARACTERS_ITEM("characters_item"),
    CHARACTERS_LEADERBOARD("characters_leaderboard"),
    CHARACTERS_ONLINE_STATUS("characters_online_status"),
    CHARACTERS_SKILL("characters_skill"),
    CHARACTERS_STAT("characters_stat"),
    CHARACTERS_STAT_BY_FACTION("characters_stat_by_faction"),
    CHARACTERS_STAT_HISTORY("characters_stat_history"),
    CHARACTERS_WEAPON_STAT("characters_weapon_stat"),
    CHARACTERS_WEAPON_STAT_BY_FACTION("characters_weapon_stat_by_faction"),
    CHARACTERS_WORLD("characters_world"),
    CHARACTER_NAME("character_name"),
    CURRENCY("currency"),
    DIRECTIVE("directive"),
    DIRECTIVE_TIER("directive_tier"),
    DIRECTIVE_TREE("directive_tree"),
    DIRECTIVE_TREE_CATEGORY("directive_tree_category"),
    EFFECT("effect"),
    EFFECT_TYPE("effect_type"),
    EMPIRE_SCORES("empire_scores"),
    
    /**
	 * To retrieve data of this collection you need to specify the arguments:
	 * type [MetagameEvent, Death, ...]
	 * 
	 */
    EVENT("event"),
    EXPERIENCE("experience"),
    EXPERIENCE_RANK("experience_rank"),
    FACILITY_LINK("facility_link"),
    FACILITY_TYPE("facility_type"),
    FACTION("faction"),
    FIRE_GROUP("fire_group"),
    FIRE_GROUP_TO_FIRE_MODE("fire_group_to_fire_mode"),
    FIRE_MODE("fire_mode"),
    FIRE_MODE_2("fire_mode_2"),
    FIRE_MODE_TO_PROJECTILE("fire_mode_to_projectile"),
    FIRE_MODE_TYPE("fire_mode_type"),
    IMAGE("image"),
    IMAGE_SET("image_set"),
    IMAGE_SET_DEFAULT("image_set_default"),
    ITEM("item"),
    ITEM_ATTACHMENT("item_attachment"),
    ITEM_CATEGORY("item_category"),
    ITEM_PROFILE("item_profile"),
    ITEM_TO_WEAPON("item_to_weapon"),
    ITEM_TYPE("item_type"),
    
    /**
	 * To retrieve data of this collection you need to specify the arguments:
	 * name [Deaths, Kills, Score, Time]
	 * period [Forever, Monthly, Weekly, Daily, OneLife]
	 * 
	 */
    LEADERBOARD("leaderboard"),
    LOADOUT("loadout"),
    MAP("map"),
    MAP_HEX("map_hex"),
    MAP_REGION("map_region"),
    MARKETING_BUNDLE("marketing_bundle"),
    MARKETING_BUNDLE_ITEM("marketing_bundle_item"),
    MARKETING_BUNDLE_WITH_ONE_ITEM("marketing_bundle_with_1_item"),
    METAGAME_EVENT("metagame_event"),
    METAGAME_EVENT_STATE("metagame_event_state"),
    OBJECTIVE("objective"),
    OBJECTIVE_SET_TO_OBJECTIVE("objective_set_to_objective"),
    OBJECTIVE_TYPE("objective_type"),
    OUTFIT("outfit"),
    OUTFIT_MEMBER("outfit_member"),
    OUTFIT_MEMBER_EXTENDED("outfit_member_extended"),
    OUTFIT_RANK("outfit_rank"),
    PLAYER_STATE("player_state"),
    PLAYER_STATE_GROUP("player_state_group"),
    PLAYER_STATE_GROUP_2("player_state_group_2"),
    PROFILE("profile"),
    PROFILE_2("profile_2"),
    PROFILE_ARMOR_MAP("profile_armor_map"),
    PROFILE_RESIST_MAP("profile_resist_map"),
    PROJECTILE("projectile"),
    PROJECTILE_FLIGHT_TYPE("projectile_flight_type"),
    REGION("region"),
    RESIST_INFO("resist_info"),
    RESIST_TYPE("resist_type"),
    RESOURCE_TYPE("resource_type"),
    REWARD("reward"),
    REWARD_GROUP_TO_REWARD("reward_group_to_reward"),
    REWARD_SET_TO_REWARD_GROUP("reward_set_to_reward_group"),
    REWARD_TYPE("reward_type"),
    SINGLE_CHARACTER_BY_ID("single_character_by_id"),
    SKILL("skill"),
    SKILL_CATEGORY("skill_category"),
    SKILL_LINE("skill_line"),
    SKILL_SET("skill_set"),
    TARGET_TYPE("target_type"),
    TITLE("title"),
    VEHICLE("vehicle"),
    VEHICLE_ATTACHMENT("vehicle_attachment"),
    VEHICLE_FACTION("vehicle_faction"),
    VEHICLE_SKILL_SET("vehicle_skill_set"),
    WEAPON("weapon"),
    WEAPON_AMMO_SLOT("weapon_ammo_slot"),
    WEAPON_DATASHEET("weapon_datasheet"),
    WEAPON_TO_ATTACHMENT("weapon_to_attachment"),
    WEAPON_TO_FIRE_GROUP("weapon_to_fire_group"),
    WORLD("world"),
    WORLD_EVENT("world_event"),
    WORLD_STAT_HISTORY("world_stat_history"),
    ZONE("zone"),
    ZONE_EFFECT("zone_effect"),
    ZONE_EFFECT_TYPE("zone_effect_type");
	
	private String name;
	
	private Collection(String name) {
		this.name = name;
	}

    public String getName() {
	    return name;
    }

    public static Collection findByName(String name) {
        for (Collection collection : Collection.values()) {
            if (collection.getName().equalsIgnoreCase(name)) {
                return collection;
            }
        }
        return null;
    }

    @Override
    public String toString() {
	    return name;
    }
}
