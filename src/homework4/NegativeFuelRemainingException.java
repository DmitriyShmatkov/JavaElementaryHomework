package homework4;

public class NegativeFuelRemainingException extends RuntimeException {

    public NegativeFuelRemainingException() {}

    public NegativeFuelRemainingException(String message) {
        super(message);
    }
}
