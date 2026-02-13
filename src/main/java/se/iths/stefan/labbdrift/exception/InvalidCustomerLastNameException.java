package se.iths.stefan.labbdrift.exception;

public class InvalidCustomerLastNameException extends RuntimeException {
    public InvalidCustomerLastNameException(String message) {
        super(message);
    }
}
