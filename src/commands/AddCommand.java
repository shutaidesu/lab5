package commands;
import model.Flat;

import java.util.Collection;

// The Add command
public class AddCommand implements Command {
    private Collection<Flat> flats;

    public AddCommand(Collection<Flat> flats) {
        this.flats = flats;
    }

    public void execute() {
        // Ask the user to input the flat information
        // Create a new flat object with the information
        // Add the flat to the collection
        System.out.println("Flat added to the collection.");
    }
}