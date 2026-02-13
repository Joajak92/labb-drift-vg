package se.iths.stefan.labbdrift.exception;

public class InvalidCustomerEmailException extends RuntimeException {
    public InvalidCustomerEmailException(String message) {
        super(message);
    }
}
