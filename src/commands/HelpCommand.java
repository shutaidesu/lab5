package commands;

// The Help command
public class HelpCommand implements Command {
    public void execute() {
        System.out.println("Available commands:");
        System.out.println("help : Display this help message");
        System.out.println("info : Print information about the collection");
        System.out.println("add : Add a new flat to the collection");
        System.out.println("delete : Delete a flat from the collection by its id");
        System.out.println("show : Print a string representation of the flat by its id");
        System.out.println("update : Update the information of the flat by its id");
        System.out.println("save : Save the collection to the file");
        System.out.println("exit : Exit the program");
    }
}
