package model;

public class House implements Comparable<House>{
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
    }

    public House(){

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public Long getNumberOfFloors(){
        return numberOfFloors;
    }

    public void setNumberOfFloors(Long numberOfFloors){
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFlatsOnFloor(){
        return numberOfFlatsOnFloor;
    }

    public void setNumberOfFlatsOnFloor(int numberOfFlatsOnFloor){
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    public long getNumberOfLifts(){
        return numberOfLifts;
    }

    public void setNumberOfLifts(long numberOfLifts){
        this.numberOfLifts = numberOfLifts;
    }

    @Override
    public int compareTo(House e){
        return name.compareTo(e.name);
    }

    @Override
    public String toString(){
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfFlatsOnFloor=" + numberOfFlatsOnFloor +
                ", numberOfLifts=" + numberOfLifts +
                "}";
    }
}
