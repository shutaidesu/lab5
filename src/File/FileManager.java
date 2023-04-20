package File;

import model.House;
import java.io.FileNotFoundException;
import java.util.Hashtable;

public class FileManager {
    private String fileName;

    public FileManager(String filename){
        this.fileName = fileName;
    }
    public Hashtable<House, String> readFile() throws FileNotFoundException{

    }
}
