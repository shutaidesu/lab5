import managers.CollectionManager;
import managers.FileManager;
import managers.CommandManager;
import commands.*;
import java.io.File;
import java.io.IOException;

import model.House;
import model.Flat;
import util.*;

public class Main {
    //importnig the path to the file
    private static String filePath = System.getenv("FILE");
    private static File inputFile = new File(filePath);

    public static void main(String[] args) throws IOException{
        System.out.println(filePath);
        // Create a File object with appropriate xml file name
        File file = new File(filePath);

        try{
            FileManager fileManager = new FileManager(filePath, null);
            collection = new Collection(fileManager);
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(2);
        }

        var fileManager = new FileManager(args[0], console);
        var collectionManager = new CollectionManager(fileManager);

        House.updateNextId(collectionManager);
        Flat.updateNextId(collectionManager);
        collectionManager.validateAll(console);

        var commandManager = new CommandManager() {{
            register("help", new Help(console, this));
            register("info", new Info(console, collectionManager));
            register("show", new Show(console, collectionManager));
            register("add", new Add(console, collectionManager));
            register("update", new Update(console, collectionManager));
            register("remove_by_id", new RemoveById(console, collectionManager));
            register("clear", new Clear(console, collectionManager));
            register("save", new Save(console, collectionManager));
            register("execute_script", new ExecuteScript(console));
            register("exit", new Exit(console));
            register("head", new Head(console, collectionManager));
            register("add_if_max", new AddIfMax(console, collectionManager));
            register("add_if_min", new AddIfMin(console, collectionManager));
            register("sum_of_price", new SumOfPrice(console, collectionManager));
            register("filter_by_price", new FilterByPrice(console, collectionManager));
            register("filter_contains_part_number", new FilterContainsPartNumber(console, collectionManager));
        }};

        new Runner(console, commandManager).interactiveMode();
    }

    }

}


