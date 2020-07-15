package census.enums;

public enum World {
	CONNERY(1, "Connery"),
	MILLER(10, "Miller"),
	COBALT(13, "Cobalt"),
	EMERALD(17, "Emerald"),
	JAEGER(19, "Jaeger"),
	BRIGGS(25, "Briggs"),
	SOLTECH(40, "Soltech"),
	GENUDINE(1000, "Genudine"),
    CERES(2000, "Ceres");
	
	private int id;
	private String name;
	
	World(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static World findWorld(String name) {
		for (World world : World.values()) {
			if (world.getName().equalsIgnoreCase(name)) {
				return world;
			}
		}
		return null;
	}
	
	public static World findWorld(int world_id) {
		for (World world : World.values()) {
			if (world.getId() == world_id) {
				return world;
			}
		}
		return null;
	}
	
}