package model;


import java.time.LocalDateTime;

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

    }
}
