
import myfile.Collection;
import myfile.FileManager;

import java.io.File;
import java.io.IOException;

public class Main {
    //importnig the path to the file
    private static String filePath = System.getenv("FILE");
    private static File inputFile = new File(filePath);

    public static void main(String[] args) throws IOException{
        System.out.println(filePath);
        // Create a File object with appropriate xml file name
        File file = new File(filePath);

        try{
            FileManager fileManager = new FileManager(filePath, );
            collection = new Collection(fileManager);
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(2);
        }

        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory(collection);

    }

}


