package census.enums;

public enum ItemType {
    GENERIC(1),
    MINIGAME(2),
    CREATE_RECIPE(3),
    REWARD_SET(4),
    EXTERNAL_VENTOR_ITEM(5),
    GIVE_QUEST(6),
    CREATE_VEHICLE(11),
    STYLE_CARD(12),
    UNLOCK_PLAYER_TITLE(13),
    GIVE_CURRENCY(14),
    GIVE_PROFILE(15),
    CUSTOMIZATION(17),
    GIVE_MOUNT(19),
    WEAPON(26),
    ATTACHMENT(27),
    BOOST(28),
    AMMO(29),
    GIVE_CERT_POINT(30),
    LOADOUT_TAB(31),
    EXECUTE_SCRIPT(32),
    VEHICLE_EQUIPMENT(33),
    NAME_CHANGE(34),
    SERVER_TRANSFER(35),
    INFANTRY_EQUIPMENT(36),
    CHARACTER_SLOT_TOKEN(37),
    VEHICLE_COSMETIC(38),
    INVANTRY_COSMETIC(39),
    SPEECH_PACK(40),
    RESOURCE_CHARGER(41),
    ADD_RESOURCE_VALUE(42),
    IMAGE_SET(43),
    TERMINAL_PROXY(44),
    IMPLANT(45),
    LEGACY_IMPLANT(46),
    FACILITY_MODULE(47);
	
	private int value;
	
	private ItemType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
