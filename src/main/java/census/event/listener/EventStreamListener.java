package census.event.listener;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import census.event.dto.AchievementEarned;
import census.event.dto.BattleRankUp;
import census.event.dto.ContinentLock;
import census.event.dto.ContinentUnlock;
import census.event.dto.Death;
import census.event.dto.FacilityControl;
import census.event.dto.GainExperience;
import census.event.dto.ItemAdded;
import census.event.dto.MetagameEvent;
import census.event.dto.PlayerFacilityCapture;
import census.event.dto.PlayerFacilityDefend;
import census.event.dto.PlayerLogin;
import census.event.dto.PlayerLogout;
import census.event.dto.SkillAdded;
import census.event.dto.VehicleDestroy;
import okhttp3.Response;

/**
 * This abstract class is used for the implementation of the Listener-pattern used in {@link census.EventStreamClient}.
 * The WebSocket may cause the following events:
 * <ul>
 *     <li><b>onClosed:</b> Occurs when the connection has been closed. Includes reason and code.</li>
 *     <li><b>onClosing:</b> Occurs shortly before the connection is closed. Includes reason and code.</li>
 *     <li><b>onOpen:</b> Occurs when the connection has been opened. Includes {@link okhttp3.Response}.</li>
 *     <li><b>onFailure:</b> When an error during regarding a message or the connection has occurred.
 *     Includes {@link Throwable} and {@link okhttp3.Response}.</li>
 *     <li><b>onException:</b> When an internal error has occurred. Includes {@link Throwable}.</li>
 * </ul>
 * <br>
 *
 * The Census Stream may respond with:
 * <ul>
 *     <li><b>onMessage:</b> Occurs when a message has been received by {@link census.EventStreamClient}.</li>
 *     <li><b>onSubscriptionResponse:</b> Occurs when a confirmation of the requested subscription was received by
 *     {@link census.EventStreamClient}.</li>
 * </ul>
 * <br>
 *
 * For all available events see <a href="http://census.daybreakgames.com/#what-is-websocket">PS2 Event Streaming</a> or
 * the available methods below.
 */
public abstract class EventStreamListener {

	//WebSocket Events
	public void onClosed(int code, String reason) {}
	public void onClosing(int code, String reason) {}
	public void onOpen(Response response) {}
	
	public void onFailure(Throwable t, Response r) {}
	public void onException(Throwable t) {}
	
	//Server Response Events
	public void onMessage(JsonNode node) {}
	public void onSubscriptionResponse(JsonNode node) {}
	public void onRecentCharIdListOrCount(JsonNode node) {}
	
	//Character Events
	public void onAchievmentEarned(AchievementEarned event) {}
	public void onBattleRankUp(BattleRankUp event) {}
	public void onDeath(Death event) {}
	public void onItemAdded(ItemAdded event) {}
	public void onSkillAdded(SkillAdded event) {}
	public void onVehicleDestroy(VehicleDestroy event) {}
	public void onGainExperience(GainExperience event) {}
	public void onPlayerFacilityCapture(PlayerFacilityCapture event) {}
	public void onPlayerFacilityDefend(PlayerFacilityDefend event) {}
	
	//Character Status Events
	public void onPlayerLogin(PlayerLogin event) {}
	public void onPlayerLogout(PlayerLogout event) {}
	
	//World Events
	public void onContinentLock(ContinentLock event) {}
	public void onContinentUnlock(ContinentUnlock event) {}
	public void onFacilityControl(FacilityControl event) {}
	public void onMetagameEvent(MetagameEvent event) {}


	/**
	 * Parses the received {@link JsonNode} and calls the corresponding events.
	 * {@link EventStreamListener#onMessage(JsonNode)} is always called.
	 * @param node The message received from the WebSocket
	 * @throws JsonParseException If an error occurred while parsing the received {@link JsonNode}.
	 * @throws JsonMappingException If the input message does not match the Class
	 * @throws IOException
	 */
	public final void propagateMessage(JsonNode node) throws JsonParseException, JsonMappingException, IOException {
		onMessage(node);
		if (node.has("subscription")) {
			onSubscriptionResponse(node.path("subscription"));
		} else if (node.has("recent_character_id_count") || node.has("recent_character_id_list")) {
			onRecentCharIdListOrCount(node.path("payload"));
		} else if (node.has("payload")){
			JsonNode payload = node.path("payload");

			switch(payload.path("event_name").asText()) {
			
			case "AchievementEarned":
				onAchievmentEarned(new ObjectMapper().readValue(payload.toString(), AchievementEarned.class));
				break;
			case "BattleRankUp":
				onBattleRankUp(new ObjectMapper().readValue(payload.toString(), BattleRankUp.class));
				break;
			case "Death":
				onDeath(new ObjectMapper().readValue(payload.toString(), Death.class));
				break;
			case "ItemAdded":
				onItemAdded(new ObjectMapper().readValue(payload.toString(), ItemAdded.class));
				break;
			case "VehicleDestroy":
				onVehicleDestroy(new ObjectMapper().readValue(payload.toString(), VehicleDestroy.class));
				break;
			case "GainExperience":
				onGainExperience(new ObjectMapper().readValue(payload.toString(), GainExperience.class));
				break;
			case "PlayerFacilityCapture":
				onPlayerFacilityCapture(new ObjectMapper().readValue(payload.toString(), PlayerFacilityCapture.class));
				break;
			case "PlayerFacilityDefend":
				onPlayerFacilityDefend(new ObjectMapper().readValue(payload.toString(), PlayerFacilityDefend.class));
				break;
			case "PlayerLogin":
				onPlayerLogin(new ObjectMapper().readValue(payload.toString(), PlayerLogin.class));
				break;
			case "PlayerLogout":
				onPlayerLogout(new ObjectMapper().readValue(payload.toString(), PlayerLogout.class));
				break;
			case "ContinentLock":
				onContinentLock(new ObjectMapper().readValue(payload.toString(), ContinentLock.class));
				break;
			case "ContinentUnlock":
				onContinentUnlock(new ObjectMapper().readValue(payload.toString(), ContinentUnlock.class));
				break;
			case "FacilityControl":
				onFacilityControl(new ObjectMapper().readValue(payload.toString(), FacilityControl.class));
				break;
			case "MetagameEvent":
				onMetagameEvent(new ObjectMapper().readValue(payload.toString(), MetagameEvent.class));
				break;
			default:
				break;
			}
		}
	}
}
