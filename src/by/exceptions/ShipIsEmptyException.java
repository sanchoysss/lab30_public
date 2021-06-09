package by.exceptions;

public class ShipIsEmptyException extends Exception{

    public ShipIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
