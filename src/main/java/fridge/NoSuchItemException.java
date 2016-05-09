package fridge;

/**
 * Created by eduard on 1/14/16.
 */
public class NoSuchItemException extends Exception {
    public NoSuchItemException(String message) {
        super(message);
    }
}
