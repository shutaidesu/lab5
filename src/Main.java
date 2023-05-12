
import commands.*;

import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

import model.Flat;
import model.House;
import util.*;
import util.console.StandardConsole;

public class Main {
    //importnig the path to the file
    private static String filePath = System.getenv("FILE");

    public static void main(String[] args){

        var console = new StandardConsole();

        var fileManager = new FileManager(filePath, console);
        var collectionManager = new CollectionManager(fileManager);

        Flat.updateNextId(collectionManager);
        collectionManager.validateAll(console);

        var commandManager = new CommandManager() {{
            register("help", new Help(console, this));
            register("info", new Info(console, collectionManager));
            register("show", new Show(console, collectionManager));
            register("insert", new Insert(console, collectionManager));
            register("update", new Update(console, collectionManager));
            register("remove_by_key", new RemoveByKey(console, collectionManager));
            register("clear", new Clear(console, collectionManager));
            register("save", new Save(console, collectionManager));
            register("execute_script", new ExecuteScript(console));
            register("exit", new Exit(console));
            register("remove_greater", new RemoveGreater(console, collectionManager));
            register("replace_if_lowe", new ReplaceIfLowe(console, collectionManager));
            register("remove_greater_key", new RemoveGreaterKey(console, collectionManager));
            register("sum_of_number_of_bathrooms", new SumOfNumberOfBathrooms(console, collectionManager));
            register("filter_by_transport", new FilterByTransport(console, collectionManager));
            register("print_descending", new PrintDescending(console, collectionManager));
        }};

        new Runner(console, commandManager).interactiveMode();
    }

    }

}


