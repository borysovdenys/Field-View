package borysov.exception;

public class TransactionException extends RuntimeException {

    public TransactionException() {
    }

    public TransactionException(String msg) {
        super(msg);
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}
