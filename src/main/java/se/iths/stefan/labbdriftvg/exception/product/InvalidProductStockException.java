package se.iths.stefan.labbdriftvg.exception.product;

public class InvalidProductStockException extends RuntimeException {
    public InvalidProductStockException(String message) {
        super(message);
    }
}
