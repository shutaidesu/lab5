package commands;
import java.util.Collection;
import model.Flat;

// The Update command
public class UpdateCommand implements Command {
    private Collection<Flat> flats;

    public UpdateCommand(Collection<Flat> flats) {
        this.flats = flats;
    }

    public void execute() {
        // Ask the user to input the id of the flat to be updated
        // Find the flat in the collection by its id
        // Ask the user to input the new information for the flat
        // Update the flat with the new information
    }
}