package commands;

import myexeption.CollectionIsEmptyException;
import myexeption.WrongAmountOfElementsException;
import managers.CollectionManager;
import model.Flat;
import util.console.Console;

/**
 * Команда 'sum_of_number_of_bathrooms'. Сумма цен всех продуктов.
 * @author shutaidesu
 */
public class SumOfNumberOfBathrooms extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public SumOfNumberOfBathrooms(Console console, CollectionManager collectionManager) {
        super("sum_of_number_of_bathrooms", "вывести сумму значений поля numberOfBathrooms для всех элементов коллекции");
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

            var sumOfBathrooms = getSumOfBathrooms();
            if (sumOfBathrooms == 0) throw new CollectionIsEmptyException();

            console.println("Сумма количества всех ванных комнат: " + sumOfBathrooms);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            console.println("Коллекция пуста!");
        }
        return false;
    }

    private Long getSumOfBathrooms() {
        return collectionManager.getCollection().stream()
                .map(Flat::getNumberOfBathrooms)
                .mapToLong(Long::longValue)
                .sum();
    }
}
