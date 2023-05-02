package myexeption;

public class WrongTypeException extends RuntimeException{
    public WrongTypeException() {
        super("неверный тип данных у введенного аргумента");
    }

    public WrongTypeException(String message) {
        super(message);
    }
}
