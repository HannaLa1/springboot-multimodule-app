package by.iba.security.exception;

public class WrongPassword extends RuntimeException{

    public WrongPassword(String message) {
        super(message);
    }
}
