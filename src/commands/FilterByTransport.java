package commands;

import model.Transport;
import myexeption.WrongAmountOfElementsException;
import managers.CollectionManager;
import model.Flat;
import util.console.Console;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Команда 'filter_by_transport'. Фильтрация квартир по транспорту.
 * @author shutaidesu
 */
public class FilterByTransport extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public FilterByTransport(Console console, CollectionManager collectionManager) {
        super("filter_by_transport <TRANSPORT>", "вывести элементы, значение поля transport которых равно заданному");
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

            var transport = Enum.parseEnum(arguments[1]);
            var flats = filterByTransport(transport);

            if (flats.isEmpty()) {
                console.println("Продуктов с ценой " + transport + " не обнаружено.");
            } else {
                console.println("Продуктов с ценой " + transport + ": " + flats.size() + " шт.\n");
                flats.forEach(console::println);
            }

            return true;

        } catch (NumberFormatException exception) {
            console.printError("Цена должна быть представлена числом!");
        } catch (WrongAmountOfElementsException exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        }
        return false;
    }

    private List<Flat> filterByTransport(Transport transport) {
        return collectionManager.getCollection().stream()
                .filter(flat -> (flat.getTransport().equals(transport)))
                .collect(Collectors.toList());
    }
}
