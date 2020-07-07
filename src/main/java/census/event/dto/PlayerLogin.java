package census.event.dto;

public class PlayerLogin extends EventPayloadObject {

	private String character_id;
	private String timestamp;
	private String world_id;

	public PlayerLogin() {
		super("PlayerLogin");
	}

	public String getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
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

	@Override
	public String toString() {
		return "PlayerLogin [character_id=" + character_id + ", timestamp=" + timestamp + ", world_id=" + world_id
				+ "]";
	}

}
