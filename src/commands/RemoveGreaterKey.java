package commands;

import model.forms.FlatForm;
import myexeption.*;

import util.console.Console;
import managers.CollectionManager;

/**
 * Команда 'remove_greater_key'. Заменяет значение по ключу.
 * @author shutaidesu
 */
public class RemoveGreaterKey extends Command{

    private final Console console;

    private final CollectionManager collectionManager;

    public RemoveGreaterKey(Console console, CollectionManager collectionManager){
        super("remove_greater_key <null>", " удалить из коллекции все элементы, ключ которых превышает заданный");
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
            console.println("* Создание нового продукта (add_if_max):");
            var product = (new FlatForm(console, collectionManager)).build();

            var maxPrice = maxPrice();
            if (product.getPrice() > maxPrice) {
                collectionManager.addToCollection(product);
                console.println("Продукт успешно добавлен!");
            } else {
                console.println("Продукт не добавлен, цена не максимальная (" + product.getPrice() + " < " + maxPrice +")");
            }
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        } catch (InvalidFormException exception) {
            console.printError("Поля продукта не валидны! Продукт не создан!");
        } catch (IncorrectInputInScriptException ignored) {}
        return false;
    }
}