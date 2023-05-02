package myexeption;

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException() {
        super("некорректная команда");
    }

    public UnknownCommandException(String message) {
        super(message);
    }
}
