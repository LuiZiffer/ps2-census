package census.event.listener;

/**
 * Printer interface used in {@link GenericEventPrinter}.
 */
public interface IPrinter {
    public void print(String message);
    public void printException(String message, Throwable t);
}
