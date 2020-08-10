package census.enums;

public enum Faction {
    NONE(0, null),
    VANU_SOVEREIGNTY(1, "VS"),
    NEW_CONGLOMERATE(2, "NC"),
    TERRAN_REPUBLIC(3, "TR"),
    NS_OPERATIVES(4, "NSO");
	
	private int id;
	private String acronym;
	
	private Faction(int id, String acronym) {
		this.id = id;
		this.acronym = acronym;
	}
	
	public static Faction findFaction(int id) {
		for (Faction faction : Faction.values()) {
			if (faction.getId() == id) {
				return faction;
			}
		}
		return null;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAcronym() {
		return acronym;
	}
}
