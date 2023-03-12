package model;
import java.time.LocalDate;
import model.House;

public class Flat implements Comparable<Flat> {
    private static int counter = 1;

    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private Double area;
    private Long numberOfRooms;
    private int numberOfBathrooms;
    private Furnish furnish;
    private Transport transport;
    private House house;

    public Flat(String name, Coordinates coordinates, Double area, Long numberOfRooms, int numberOfBathrooms,
                Furnish furnish, Transport transport, House house) {
        setId();
        setName(name);
        setCoordinates(coordinates);
        setCreationDate();
        setArea(area);
        setNumberOfRooms(numberOfRooms);
        setNumberOfBathrooms(numberOfBathrooms);
        setFurnish(furnish);
        setTransport(transport);
        setHouse(house);
    }

    private void setId() {
        this.id = counter;
        counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name of the flat cannot be null or empty");
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("The coordinates of the flat cannot be null");
        }
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    private void setCreationDate() {
        this.creationDate = LocalDate.now();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("The area of the flat must be greater than 0");
        }
        this.area = area;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Long numberOfRooms) {
        if (numberOfRooms <= 0) {
            throw new IllegalArgumentException("The number of rooms in the flat must be greater than 0");
        }
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        if (numberOfBathrooms <= 0) {
            throw new IllegalArgumentException("The number of bathrooms in the flat must be greater than 0");
        }
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        if (transport == null) {
            throw new IllegalArgumentException("The transport field of the flat cannot be null");
        }
        this.transport = transport;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException("The house field of the flat cannot be null");
        }
        this.house = house;
    }

    @Override
    public int compareTo(Flat other) {
        return this.creationDate.compareTo(other.creationDate);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",";
    }
}