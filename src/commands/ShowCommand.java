package commands;
import java.util.Collection;
import model.Flat;

// The Show command
public class ShowCommand implements Command {
    private Collection<Flat> flats;

    public ShowCommand(Collection<Flat> flats) {
        this.flats = flats;
    }

    public void execute() {
        // Ask the user to input the id of the flat to be shown
        // Find the flat in the collection by its id
        // Print a string representation of the flat
    }
}
