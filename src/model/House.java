package model;

import managers.CollectionManager;

import java.util.*;

/**
 * Класс организации
 * @author shutaidesu
 */

public class House{
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

    public static Map<String, House> allHouse() {
        return house;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    public boolean validate() {
        if (name == null || name.isEmpty()) return false;
        if (year <= 0) return false;
        if (numberOfFloors == null || numberOfFloors <= 0) return false;
        if (numberOfFlatsOnFloor <= 0) return false;
        return numberOfLifts <= 0;
    }

    public String getName() {
        return name;
    }

    public long getYear() {
        return year;
    }

    public long getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    public long getNumberOfLifts(){
        return numberOfLifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House that = (House) o;
        return numberOfFloors == that.numberOfFloors && Objects.equals(numberOfFlatsOnFloor, that.numberOfFlatsOnFloor)&& Objects.equals(name, that.name) && year == that.year && Objects.equals(numberOfLifts, that.numberOfLifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfFloors, numberOfFlatsOnFloor, numberOfLifts);
    }

    @Override
    public String toString() {
        return "Дом \"" + name + "\"" +
                "; Год постройки: " + year +
                "; Количество этажей: " + numberOfFloors +
                "; Количество квартир на этаже: " + numberOfFlatsOnFloor +
                "; Количество лифтов: " + numberOfLifts;
    }
}
