package pl.javastart.model;

public class EmailExistsException extends RuntimeException {


    public EmailExistsException(String message) {
        super(message);
    }
}
