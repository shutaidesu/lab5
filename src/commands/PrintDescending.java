package commands;

import myfile.Collection;

import java.util.Iterator;
import java.util.Set;

public class PrintDescending {
    public PrintDescending(Collection collection){
        Set<Integer> keys = collection.keySet();
        Iterator<Integer> itr = keys.iterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            System.out.println(i + " " + collection.getById(i));
        }
    }
}
