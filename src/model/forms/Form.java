package model.forms;

import myexeption.IncorrectInputInScriptException;
import myexeption.InvalidFormException;

/**
 * Абстрактный класс формы для ввода пользовательских данных.
 * @param <T> создаваемый объект
 * @author shutaidesu
 */
public abstract class Form<T> {
    public abstract T build() throws IncorrectInputInScriptException, InvalidFormException;
}