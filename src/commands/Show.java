package commands;

import myexeption.EmptyCollectionException;
import myfile.Collection;
import model.HouseComplex;
/**
 * The `ShowCommand` class is a command that prints all the elements of the collection in string
 * representation
 */
public class Show extends Command{
    private Collection collection;
    public Show(Collection collection) {
        this.collection=collection;
    }

    /**
     * * Prints all the organizations in the collection
     * @param args the arguments passed to the command.
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        for (HouseComplex house : collection.getHouse()){
            System.out.println(house);
        }
    }
}
