package model;

import managers.CollectionManager;
import util.Element;

import java.util.*;

/**
 * Класс организации
 * @author shutaidesu
 */

public class House extends Element{
    private static transient Map<String, House> house = new HashMap<>();
    private String name; //Поле может быть null
    private int year; //Значение поля должно быть больше 0
    private Long numberOfFloors; //Поле не может быть null, Значение поля должно быть больше 0
    private int numberOfFlatsOnFloor; //Значение поля должно быть больше 0
    private long numberOfLifts; //Значение поля должно быть больше 0

    public House(String name, int year, Long numberOfFloors, int numberOfFlatsOnFloor, long numberOfLifts){
        this.name = name;
        this.year = year;
        this.numberOfFloors = numberOfFloors;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        this.numberOfLifts = numberOfLifts;
        house.put(this.name, this);
    }
    /**
     * Обновляет указатель следующего ID
     * @param collectionManager манагер коллекций
     */
    public static void updateNextId(CollectionManager collectionManager) {
        collectionManager
                .getCollection()
                .stream()
                .map(Flat::getHouse)
                .filter(Objects::nonNull)
                .forEach(house -> {
                    house.put(house.name, house);
                });

        var maxId = collectionManager
                .getCollection()
                .stream()
                .map(Flat::getHouse)
                .filter(Objects::nonNull)
                .map(House::getId)
                .mapToInt(Integer::intValue).max().orElse(0);
        nextId = maxId + 1;
    }

    public static Map<String, House> allHouse() {
        return house;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if (id == null || id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (year <= 0) return false;
        if (numberOfFloors == null || numberOfFloors <= 0) return false;
        if (numberOfFlatsOnFloor <= 0) return false;
        return numberOfLifts <= 0;
    }

    public static House byId(Integer id) {
        return house.get(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    @Override
    public int compareTo(Element element) {
        return (this.id - element.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House that = (House) o;
        return employeesCount == that.employeesCount && Objects.equals(id, that.id) && Objects.equals(name, that.name) && type == that.type && Objects.equals(postalAddress, that.postalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employeesCount, type, postalAddress);
    }

    @Override
    public String toString() {
        return "Организация \"" + name+ "\" №" + id +
                "; Число сотрудников: " + employeesCount +
                "; Вид: " + type +
                "; Адрес: " + postalAddress;
    }
}
}
