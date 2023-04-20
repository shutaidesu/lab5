package model;


import myexeption.NullArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class HouseComplex implements Comparable<HouseComplex>{
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

    public HouseComplex(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Double area, Integer numberOfRooms, long numberOfBathrooms, Furnish furnish, Transport transport, House house){
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getArea(){
        return area;
    }

    public void setArea(Double area){
        this.area = area;
    }

    public Integer getNumberOfRooms(){
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms){
        this.numberOfRooms = numberOfRooms;
    }

    public long getNumberOfBathrooms(){
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(long numberOfBathrooms){
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Furnish getFurnish(){
        return furnish;
    }

    public void setFurnish(Furnish furnish){
        this.furnish = furnish;
    }

    public Transport getTransport(){
        return transport;
    }

    public void setTransport(Transport transport){
        this.transport = transport;
    }

    public House getHouse(){
        return house;
    }

    public void setHouse(House house){
        this.house = house;
    }

    public void checkHouseComplex(){
        if(getId() == null) throw new NullArgumentException("id не может быть null");
        if(getId() <= 0) throw new IllegalArgumentException("id не положительный");
        if(Objects.equals(getName(),"null") || getName() == null || getName().isEmpty() || getName().isBlank()) throw new NullArgumentException("имя пустое");
        if(getCoordinates() == null) throw  new NullArgumentException("пустые координаты");
        if(getCreationDate() == null)throw new NullArgumentException("нулевое время");
        if(getArea() == null) throw new NullArgumentException("area не может быть null");
        if(getArea() <= 0) throw new IllegalArgumentException("area не положительный");
        if(getNumberOfRooms() == null) throw new NullArgumentException("numberOfRooms не может быть null");
        if(getNumberOfRooms() <= 0) throw new IllegalArgumentException("numberOfRooms не положительный");
        if(getNumberOfBathrooms() <= 0) throw new IllegalArgumentException("numberOfBathrooms не положительный");
        if(getFurnish() == null) throw new NullArgumentException("некорректное значение фурнитуры");
        if(getTransport() == null) throw new NullArgumentException("некорректный транспорт");
        if(getHouse().getName() == null) throw new NullArgumentException("некорректный формат имени");
        if(getHouse().getYear() <= 0) throw new IllegalArgumentException("некорректный формат года");
        if(getHouse().getNumberOfFloors() == null) throw new NullArgumentException("numberOfFloors не может быть null");
        if(getHouse().getNumberOfFloors() <= 0) throw new IllegalArgumentException("numberOfFloors не положительный");
        if(getHouse().getNumberOfFlatsOnFloor() <= 0) throw new IllegalArgumentException("numberOfFlatsOnFloor не положительный");
        if(getHouse().getNumberOfLifts() <= 0 ) throw new IllegalArgumentException("numberOfLifts не положительный");
    }

    @Override
    public int compareTo(HouseComplex o) {
        if (!Objects.equals(area, o.area)) {
            return Double.compare(area, o.area);
        }
        if (name.length() != o.name.length()) {
            return Integer.compare(name.length(), o.name.length());
        }
        return Long.compare(id, o.id);
    }

    @Override
    public String toString(){
        return "HouseComplex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms" + numberOfBathrooms +
                ", furnish=" + furnish +
                ", transport=" + transport +
                ", house=" + house +
                "}";
    }
}
