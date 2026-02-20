package se.iths.stefan.labbdriftvg.exception.product;

public class InvalidProductPriceException extends RuntimeException {
    public InvalidProductPriceException(String message) {
        super(message);
    }
}
