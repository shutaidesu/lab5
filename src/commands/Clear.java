package commands;

import managers.CollectionManager;
import util.console.Console;

/**
 * Команда 'clear'. Очищает коллекцию.
 * @author shutaidesu
 */
public class Clear extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        collectionManager.clearCollection();
        console.println("Коллекция очищена!");
        return true;
    }
}