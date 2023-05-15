package commands;

import myexeption.CollectionIsEmptyException;
import myexeption.NotFoundException;
import myexeption.WrongAmountOfElementsException;
import util.console.Console;
import managers.CollectionManager;

/**
 * Команда 'replace_if_lowe'. Заменяет значение по ключу.
 * @author shutaidesu
 */
public class ReplaceIfLowe extends Command{

    private final Console console;

    private final CollectionManager collectionManager;

    public ReplaceIfLowe(Console console, CollectionManager collectionManager){
        super("replace_if_lowe null {element}", "заменить значение по ключу, если новое значение меньше старого");
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
            var flatToReplace = collectionManager.getById(id);

            if (flatToReplace == null) throw new NotFoundException();

            collectionManager.getCollectionForSet().replace(flatToReplace, String.valueOf(collectionManager.minValue()));
            console.println("Квартира успешно заменена.");
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
