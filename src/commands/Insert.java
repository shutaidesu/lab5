package commands;

import myexeption.IncorrectInputInScriptException;
import myexeption.InvalidFormException;
import myexeption.WrongAmountOfElementsException;
import managers.CollectionManager;
import model.forms.FlatForm;
import util.console.Console;

/**
 * Команда 'insert'. Добавляет новый элемент в коллекцию.
 * @author shutaidesu
 */
public class Insert extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Insert(Console console, CollectionManager collectionManager) {
        super("insert null {element}", "добавить новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            console.println("* Создание новой квартиры:");
            collectionManager.addToCollection((new FlatForm(console, collectionManager)).build());
            console.println("Квартира успешно добавлена!");
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        } catch (InvalidFormException exception) {
            console.printError("Поля квартиры не валидны! Квартира не создана!");
        } catch (IncorrectInputInScriptException ignored) {}
        return false;
    }
}
