package myfile;

import model.HouseComplex;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class FileManager {
    private String fileName;

    public FileManager(String filename){
        this.fileName = fileName;
    }
    public Hashtable<HouseComplex, String> readFile() throws FileNotFoundException{
        Hashtable<HouseComplex, String> houseComplex = new Hashtable<>();
        try(InputStreamReader inp = new InputStreamReader()){

        }
    }
}
