package model;

public class Coordinates {
    private int x; //Максимальное значение поля: 386
    private int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){

    }

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
