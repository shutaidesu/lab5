
import myfile.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import myfile.Collection;
import javax.xml.stream.XMLStreamException;
public class Main {
    //importnig the path to the file
    private static String filePath = System.getenv("FILE");

    private static boolean bid, bname, barea, bcreationdate, bnumberOfRooms;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException
    {
        // Create a File object with appropriate xml file name
        File file = new File(filePath);

        try{
            FileManager fileManager = new FileManager(filePath);
            collection = new Collection(fileManager);
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(2);
        }

        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory(collection);
    }

}


