package model;

import util.Validatable;
import java.util.Objects;

/**
 * Классс координат.
 * @author shutaidesu
 */
public class Coordinates implements Validatable {
    private final Integer x; // Поле не может быть null и не может быть больше 386
    private final Integer y; // Поле не может быть null

    public Coordinates (Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if (x == null || x > 386) return false;
        return y != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}