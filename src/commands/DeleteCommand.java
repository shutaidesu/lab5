package commands;
import model.Flat;
import java.util.Collection;

// The Delete command
public class DeleteCommand implements Command {
    private Collection<Flat> flats;

    public DeleteCommand(Collection<Flat> flats) {
        this.flats = flats;
    }

    public void execute() {
        // Ask the user to input the id of the flat to be deleted
        // Find the flat in the collection by its id
        // Remove the flat from the collection
        System.out.println("Flat deleted from the collection.");
    }
}