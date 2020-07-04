package census.enums;

public enum ResourceType {
    FUEL(7),
    HEAVY_SHIELD(9),
    CLOAKER_JUICE(35),
    MEDIC_FUEL(38),
    NC_MAX_AEGIS_SHIELD_01(41),
    NC_MAX_AEGIS_SHIELD_02(43),
    NC_MAX_AEGIS_SHIELD_03(44),
    NC_MAX_AEGIS_SHIELD_04(45),
    NC_MAX_AEGIS_SHIELD_05(46),
    VS_MAX_ABILITY_ZEALOT(50),
    CORTIUM(58),
    AMBUSHER_FUEL(75),
    NSO_MAX_TIME_BOMB(133);
	
	private int value;
	
	private ResourceType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
