package se.iths.stefan.labbdriftvg.exception.product;

public class InvalidProductNameException extends RuntimeException {
    public InvalidProductNameException(String message) {
        super(message);
    }
}
