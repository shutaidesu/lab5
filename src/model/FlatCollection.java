package model;
import java.util.HashSet;

public class FlatCollection {
    private HashSet<Flat> flats;

    public FlatCollection() {
        this.flats = new HashSet<>();
    }

    public HashSet<Flat> getFlats() {
        return flats;
    }

    public void setFlats(HashSet<Flat> flats) {
        this.flats = flats;
    }
}
