package commands;

import model.Flat;
import util.console.Console;
import managers.CollectionManager;

import java.util.Iterator;
import java.util.Set;

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
        Set<Flat> keys = collectionManager.getCollectionForSet().keySet();
        Iterator<Flat> itr = keys.iterator();

        // traverse the TreeMap using iterator
        while (itr.hasNext()) {
            int i = itr.next().getId();
            System.out.println(i + " " + collectionManager.getById(i));
        }
        return true;
    }
}