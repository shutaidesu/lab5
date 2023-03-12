package commands;
import model.Flat;
import java.util.Collection;

// The Info command
public class InfoCommand implements Command {
    private Collection<Flat> flats;

    public InfoCommand(Collection<Flat> flats) {
        this.flats = flats;
    }

    public void execute() {
        System.out.println("Collection size: " + flats.size());
        // Other information about the collection
    }
}