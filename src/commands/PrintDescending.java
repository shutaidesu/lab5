package commands;

import util.console.Console;
import managers.CollectionManager;

/**
 * Команда 'print_descending'. Выводит элементы в порядке убывания.
 * @author shutaidesu
 */
public class PrintDescending extends Command{

    private final Console console;

    private final CollectionManager collectionManager;

    public PrintDescending(Console console, CollectionManager collectionManager){
        super("print_descending", "вывести элементы коллекции в порядке убывания");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {

    }
}