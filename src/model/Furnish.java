package model;
/**
 * Перечисление качества мебели.
 * @author shutaidesu
 */
public enum Furnish {
    DESIGNER,
    FINE,
    BAD,
    LITTLE;

    /**
     * @return Строка со всеми элементами enum'а через строку.
     */
    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var weaponType : values()) {
            nameList.append(weaponType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
