package commands;

import myexeption.*;
import managers.CollectionManager;
import util.console.Console;

/**
 * Команда 'remove_by_key'. Удаляет элемент из коллекции.
 * @author shutaidesu
 */
public class RemoveByKey extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveByKey(Console console, CollectionManager collectionManager) {
        super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
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
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            var id = Integer.parseInt(arguments[1]);
            var productToRemove = collectionManager.getById(id);
            if (productToRemove == null) throw new NotFoundException();

            collectionManager.removeFromCollection(productToRemove);
            console.println("Продукт успешно удален.");
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            console.printError("ID должен быть представлен числом!");
        } catch (NotFoundException exception) {
            console.printError("Продукта с таким ID в коллекции нет!");
        }
        return false;
    }
}
