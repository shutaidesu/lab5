package model.forms;

import model.*;
import myexeption.*;
import util.console.Console;
import managers.CollectionManager;
import util.Interrogator;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;


/**
 * Форма продукта.
 * @author shutaidesu
 */
public class FlatForm extends Form<Flat> {
    private final Console console;
    private final CollectionManager collectionManager;

    private final long MIN_AREA = 0;

    private final long MIN_ROOMS = 0;

    public FlatForm(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public Flat build() throws IncorrectInputInScriptException, InvalidFormException {
        var flat = new Flat(
                askName(),
                askCoordinates(),
                LocalDateTime.now(),
                askArea(),
                askNumberOfRooms(),
                askNumberOfBathrooms(),
                askFurnish(),
                askTransport(),
                askHouse()
        );
        if (!flat.validate()) throw new InvalidFormException();
        return flat;
    }

    private String askName() throws IncorrectInputInScriptException {
        String name;
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.println("Введите название квартиры:");
                console.ps2();

                name = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Название не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                console.printError("Название не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }

        return name;
    }

    private Coordinates askCoordinates() throws IncorrectInputInScriptException, InvalidFormException {
        return new CoordinatesForm(console).build();
    }

    private Double askArea() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        double area;
        while (true) {
            try {
                console.println("Введите площадь квартиры:");
                console.ps2();

                var strArea = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strArea);

                area = Integer.parseInt(strArea);
                if (area < MIN_AREA) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Площадь квартиры не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Площадь квартиры должен быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Площадь квартиры должен быть представлен числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return area;
    }

    private Integer askNumberOfRooms() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        int numberOfRooms;
        while (true) {
            try {
                console.println("Введите число комнат для квартиры:");
                console.ps2();

                var strNumber = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strNumber);

                numberOfRooms = Integer.parseInt(strNumber);
                if (numberOfRooms < MIN_AREA) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Число комнат квартиры не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Число комнат квартиры должно быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Число комнат квартиры должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return numberOfRooms;
    }

    private Long askNumberOfBathrooms() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        long askNumberOfBathrooms;
        while (true) {
            try {
                console.println("Введите число ванных комнат для квартиры:");
                console.ps2();

                var strNumber = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strNumber);

                askNumberOfBathrooms = Long.parseLong(strNumber);
                if (askNumberOfBathrooms < MIN_ROOMS) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Число ванных комнат для квартиры не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Число ванных комнат для квартиры должно быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Число ванных комнат для квартиры должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return askNumberOfBathrooms;
    }

    private House askHouse(){
        return null;
    }

    private Furnish askFurnish(){
        return null;
    }

    private Transport askTransport(){
        return null;
    }
}
