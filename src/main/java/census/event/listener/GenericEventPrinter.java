package census.event.listener;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

import okhttp3.Response;

/**
 * A simple event listener printing all events using the {@link IPrinter} interface.
 * The default constructor uses the System.out outputstream and {@link Throwable#printStackTrace()} to print.
 * The constructor {@link GenericEventPrinter#GenericEventPrinter(IPrinter)} allows for a custom printing implementation.
 */
public class GenericEventPrinter extends EventStreamListener {

	private IPrinter printer;

	public GenericEventPrinter() {
		printer = new IPrinter() {
			@Override
			public void print(String message) {
				System.out.println(message);
			}

			@Override
			public void printException(String message, Throwable t) {
				System.out.println(message);
				t.printStackTrace();
			}
		};
	}

	public GenericEventPrinter(IPrinter printer) {
		this.printer = printer;
	}

	@Override
	public void onMessage(JsonNode node) {
		printer.print("Received: " + node.toString());
	}

	@Override
	public void onSubscriptionResponse(JsonNode node) {
		printer.print("Sub Response: " + node.toString());
	}

	@Override
	public void onRecentCharIdListOrCount(JsonNode node) {
		printer.print("CharIdListOrCount: " + node.toString());
	}

	@Override
	public void onClosed(int code, String reason) {
		printer.print("Closed: [" + code + "] " + reason);
	}

	@Override
	public void onClosing(int code, String reason) {
		printer.print("Closing: [" + code + "] " + reason);
	}

	@Override
	public void onOpen(Response response) {
		try {
			printer.print("Open: " + response.body().string());
		} catch (IOException e) {
			printer.printException(e.getMessage(), e);
		}
	}

	@Override
	public void onFailure(Throwable t, Response r) {
		printer.printException("Failure: " + r, t);
	}

	@Override
	public void onException(Throwable t) {
		printer.printException("Exception: " + t.getMessage(), t);
	}
}
