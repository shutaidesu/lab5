package model;

import java.util.Objects;

public class House {
    private String name;
    private Integer year;
    private long numberOfFloors;
    private int numberOfFlatsOnFloor;
    private Integer numberOfLifts;

    public House(String name, Integer year, long numberOfFloors, int numberOfFlatsOnFloor, Integer numberOfLifts) {
        this.name = name;
        this.year = year;
        this.numberOfFloors = numberOfFloors;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        this.numberOfLifts = numberOfLifts;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public long getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    public Integer getNumberOfLifts() {
        return numberOfLifts;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfFlatsOnFloor=" + numberOfFlatsOnFloor +
                ", numberOfLifts=" + numberOfLifts +
                '}';
    }
}
