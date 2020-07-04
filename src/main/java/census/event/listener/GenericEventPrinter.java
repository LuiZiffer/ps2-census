package census.event.listener;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

import okhttp3.Response;

public class GenericEventPrinter extends EventStreamListener {

	private void print(String str) {
		System.out.println(str);
	}
	
	@Override
	public void onMessage(JsonNode node) {
		print("Received: " + node.toString());
	}

	@Override
	public void onSubscriptionResponse(JsonNode node) {
		print("Sub Response: " + node.toString());
	}

	@Override
	public void onRecentCharIdListOrCount(JsonNode node) {
		print("CharIdListOrCount: " + node.toString());
	}

	@Override
	public void onClosed(int code, String reason) {
		print("Closed: [" + code + "] " + reason);
	}

	@Override
	public void onClosing(int code, String reason) {
		print("Closing: [" + code + "] " + reason);
	}

	@Override
	public void onOpen(Response response) {
		try {
			print("Open: " + response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFailure(Throwable t, Response r) {
		print("Failure: " + r);
		t.printStackTrace();
	}

	@Override
	public void onException(Throwable t) {
		print("Exception: " + t.getMessage());
		t.printStackTrace();
	}
	
	
}
