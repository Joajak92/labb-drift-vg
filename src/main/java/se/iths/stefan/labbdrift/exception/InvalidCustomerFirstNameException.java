package se.iths.stefan.labbdrift.exception;

public class InvalidCustomerFirstNameException extends RuntimeException {
    public InvalidCustomerFirstNameException(String message) {
        super(message);
    }
}
