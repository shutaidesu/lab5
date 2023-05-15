package commands;

import model.Flat;
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
        super("remove_greater_key null", " удалить из коллекции все элементы, ключ которых превышает заданный");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        try{
            if (arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            var id = Integer.parseInt(arguments[1]);
            Flat flatToRemove;
            for(int i = 0; i < collectionManager.collectionSize(); i++) {
                flatToRemove = collectionManager.getById(i);
                if (flatToRemove == null) throw new NotFoundException();
                if (id > collectionManager.getId())
                    collectionManager.removeFromCollection(flatToRemove);
            }
            console.println("Квартиры успешно удалены.");
            return true;

        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.printError("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            console.printError("ID должен быть представлен числом!");
        } catch (NotFoundException exception) {
            console.printError("Квартиры с таким ID в коллекции нет!");
        }
        return false;
    }
}