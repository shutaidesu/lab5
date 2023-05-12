package model;


import managers.CollectionManager;
import util.Element;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс продукта
 * @author maxbarsukov
 */
public class Flat extends Element{
    private static int nextId = 1;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double area; //Значение поля должно быть больше 0
    private Integer numberOfRooms; //Значение поля должно быть больше 0
    private long numberOfBathrooms; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле может быть null
    private Transport transport; //Поле не может быть null
    private House house; //Поле не может быть null

    public Flat(String name, Coordinates coordinates, LocalDateTime creationDate, Double area, Integer numberOfRooms, long numberOfBathrooms, Furnish furnish, Transport transport, House house){
        this.id = nextId;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.furnish = furnish;
        this.transport = transport;
        this.house = house;
    }
    /**
     * Обновляет указатель следующего ID
     * @param collectionManager манагер коллекций
     */
    public static void updateNextId(CollectionManager collectionManager) {
        var maxId = collectionManager
                .getCollection()
                .stream().filter(Objects::nonNull)
                .map(Flat::getId)
                .mapToInt(Integer::intValue).max().orElse(0);
        nextId = maxId + 1;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (creationDate == null) return false;
        if (area == null || area <= 0) return false;
        if (numberOfRooms == null || numberOfRooms <= 0) return false;
        return numberOfBathrooms <= 0;
    }

    public void update(Flat flat) {
        this.name = flat.name;
        this.coordinates = flat.coordinates;
        this.creationDate = flat.creationDate;
        this.area = flat.area;
        this.numberOfRooms = flat.numberOfRooms;
        this.numberOfBathrooms = flat.numberOfBathrooms;
        this.furnish = flat.furnish;
        this.transport = flat.transport;
        this.house = flat.house;
    }

    public static void touchNextId() {
        nextId++;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getArea() {
        return area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public long getNumberOfBathrooms(){
        return numberOfBathrooms;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public Transport getTransport() {
        return transport;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public int compareTo(Element element) {
        return (this.id - element.getId());
    }

    public int compareTo(Flat flat) {
        return this.area.compareTo(flat.area);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return id == flat.id && Objects.equals(name, flat.name) && Objects.equals(coordinates, flat.coordinates)
                && Objects.equals(creationDate, flat.creationDate) && Objects.equals(area, flat.area)
                && Objects.equals(numberOfRooms, flat.numberOfRooms) && numberOfBathrooms == flat.numberOfBathrooms
                && Objects.equals(house, flat.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, area, numberOfRooms, numberOfBathrooms, house);
    }

    @Override
    public String toString() {
        String info = "";
        info += "Дом №" + id;
        info += " (Построен " + creationDate.toString() + ")";
        info += "\n Название: " + name;
        info += "\n Местоположение: " + coordinates;
        info += "\n Площадь: " + area;
        info += "\n Количество комнат: " + ((numberOfRooms == null) ? null : "'" + numberOfRooms + "'");
        info += "\n Количество ванных комнат: " + numberOfBathrooms;
        info += "\n Дом:\n    " + house;
        return info;
    }
}
}
