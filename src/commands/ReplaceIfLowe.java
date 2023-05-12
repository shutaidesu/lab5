package commands;

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
        super("replace_if_lowe <null> {element}", "заменить значение по ключу, если новое значение меньше старого");
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

        } catch (){

        }
    }
}
