package census.event.dto;

public class ItemAdded extends EventPayloadObject {

	private String character_id;
	private String context;
	private String item_count;
	private String item_id;
	private String timestamp;
	private String world_id;
	private String zone_id;
	
	public ItemAdded() {
		super("ItemAdded");
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getItem_count() {
		return item_count;
	}

	public void setItem_count(String item_count) {
		this.item_count = item_count;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getWorld_id() {
		return world_id;
	}

	public void setWorld_id(String world_id) {
		this.world_id = world_id;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	@Override
	public String toString() {
		return "ItemAdded [character_id=" + character_id + ", context=" + context + ", item_count=" + item_count
				+ ", item_id=" + item_id + ", timestamp=" + timestamp + ", world_id=" + world_id + ", zone_id="
				+ zone_id + "]";
	}

}
