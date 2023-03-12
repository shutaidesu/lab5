package commands;
import java.util.Collection;
import model.Flat;

// The Save command
public class SaveCommand implements Command {
    private Collection<Flat> flats;

    public SaveCommand(Collection<Flat> flats) {
        this.flats = flats;
    }

    public void execute()