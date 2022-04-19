package by.iba.security.exception;

public class BannedUserException extends RuntimeException{

    public BannedUserException(String message) {
        super(message);
    }
}
