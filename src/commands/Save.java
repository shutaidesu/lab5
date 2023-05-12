package commands;

import managers.Collection;

/**
 * Write the collection to the file
 */
public class Save extends Command{
    private Collection collection;

    public Save(Collection collection) {
        this.collection = collection;
    }
    /**
     * Write the collection to the file
     */

    @Override
    public void execute(String[] args){
        System.out.println("");
    }
}
