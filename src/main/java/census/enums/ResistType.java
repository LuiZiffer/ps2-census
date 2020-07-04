package census.enums;

public enum ResistType {
    NONE(0),
    MELEE(1),
    SMALL_ARM(2),
    HEAVY_MACHINE_GUN(4),
    HEAVY_ANTI_ARMOR(5),
    EXPLOSIVE(6),
    TANK_SHELL(7),
    AIRCRAFT_MACHINE_GUN(8),
    ANTI_VEHICLE_MINE(9),
    FLAK_EXPLOSIVE_BLAST(12),
    ANTI_AIRCRAFT_MACHINE_GUN(22),
    AIR_TO_GROUND_WARHEAD(23),
    ARMOR_PIERCING_CHAIN_GUN(28),
    DEFAULT_ROCKET_LAUNCHER(34),
    ANTI_MATERIEL_RIFLE(40),
    WHALE_HUNTER(45),
    CORE_EXPLOSION(46);
	
	private int value;
	
	private ResistType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
