package commands;

/**
 * Интерфейс для всех выполняемых команд.
 * @author shutaidesu
 */
public interface Executable {
    /**
     * Выполнить что-либо.
     *
     * @param arguments Аргумент для выполнения
     * @return результат выполнения
     */
    boolean apply(String[] arguments);
}
