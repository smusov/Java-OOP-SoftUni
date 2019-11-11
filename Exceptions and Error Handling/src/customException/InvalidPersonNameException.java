package customException;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }

    public InvalidPersonNameException() {
        this("Student name cannot be contains numbers or special symbols!");
    }
}
