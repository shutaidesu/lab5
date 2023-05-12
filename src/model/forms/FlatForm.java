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
                askYear(),
                askNumberOfFloors(),
                askNumberOfLifts(),
                askNumberOfFlatsOnFloor()
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

    private Integer askYear() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        int year;
        while (true) {
            try {
                console.println("Введите год квартиры:");
                console.ps2();

                var strPrice = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strPrice);

                year = Integer.parseInt(strPrice);
                if (year < MIN_AREA) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Год квартиры не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Год квартиры должен быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Год квартиры должен быть представлен числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return year;
    }

    private Integer askNumberOfFlatsOnFloor() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        int numberOfFlatsOnFloor;
        while (true) {
            try {
                console.println("Введите год квартиры:");
                console.ps2();

                var strPrice = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strPrice);

                numberOfFlatsOnFloor = Integer.parseInt(strPrice);
                if (numberOfFlatsOnFloor < MIN_AREA) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Год квартиры не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Год квартиры должен быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Год квартиры должен быть представлен числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return numberOfFlatsOnFloor;
    }

    private Long askNumberOfFloors() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        long numberOfFloors;
        while (true) {
            try {
                console.println("Введите цену продукта:");
                console.ps2();

                var strPrice = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strPrice);

                numberOfFloors = Long.parseLong(strPrice);
                if (numberOfFloors < MIN_ROOMS) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Цена продукта не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Цена продукта должна быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Цена продукта должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return numberOfFloors;
    }

    private Long askNumberOfLifts() throws IncorrectInputInScriptException {
        var fileMode = Interrogator.fileMode();
        long numberOfLifts;
        while (true) {
            try {
                console.println("Введите цену продукта:");
                console.ps2();

                var strPrice = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(strPrice);

                numberOfLifts = Long.parseLong(strPrice);
                if (numberOfLifts < MIN_ROOMS) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Цена продукта не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                console.printError("Цена продукта должна быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                console.printError("Цена продукта должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return numberOfLifts;
    }

    private String askPartNumber() throws IncorrectInputInScriptException {
        String partNumber;
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.println("Введите номер части продукта:");
                console.ps2();

                partNumber = Interrogator.getUserScanner().nextLine().trim();
                if (fileMode) console.println(partNumber);
                if (partNumber.equals("")) {
                    partNumber = null;
                }
                break;
            } catch (NoSuchElementException exception) {
                console.printError("Номер части не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        }

        return partNumber;
    }
}
