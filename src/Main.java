import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import model.Flat;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Main <filename>");
            System.exit(1);
        }
        String filename = args[0];
        HashSet<Flat> flats = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String json = scanner.nextLine();
                Flat flat = Flat.fromJson(json);
                flats.add(flat);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            System.exit(1);
        } catch (JsonParseException e) {
            System.err.println("Invalid JSON in file: " + filename);
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Error reading file: " + filename);
            System.err.println(e.getMessage());
            System.exit(1);
        }
        // rest of the program добавить че тут надо емае
        switch(){
            case "help":
                printHelp();
                break;
        }

    }

    public static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  add {flat}        - add a new flat to the collection");
        System.out.println("  show             - show all flats in the collection");
        System.out.println("  remove_by_id {id} - remove a flat with the specified id");
        System.out.println("  clear            - remove all flats from the collection");
        System.out.println("  save {file}      - save the collection to the specified file");
        System.out.println("  load {file}      - load flats from the specified file to the collection");
        System.out.println("  help             - display information about the available commands");
        System.out.println("  exit             - exit the program");
    }

}


