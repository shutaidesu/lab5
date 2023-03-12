package commands;
import java.util.Scanner;
import java.util.HashSet;
import model.Flat;

public class InteractiveMode {
    private static Scanner scanner = new Scanner(System.in);
    private static HashSet<Flat> flats = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the interactive mode.");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "add":
                    addFlat(tokens);
                    break;
                case "remove_by_id":
                    removeFlatById(tokens);
                    break;
                case "clear":
                    clearFlats();
                    break;
                case "show":
                    showFlats();
                    break;
                case "info":
                    showInfo();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }

        System.out.println("\nGoodbye!");
    }

    private static void addFlat(String[] tokens) {
        // Parse and validate input to create a new Flat object
        // Add the new Flat object to the flats HashSet
    }

    private static void removeFlatById(String[] tokens) {
        // Parse and validate input to get the ID of the Flat to remove
        // Remove the Flat with the specified ID from the flats HashSet
    }

    private static void clearFlats() {
        flats.clear();
        System.out.println("All flats have been removed.");
    }

    private static void showFlats() {
        if (flats.isEmpty()) {
            System.out.println("There are no flats to show.");
        } else {
            for (Flat flat : flats) {
                System.out.println(flat);
            }
        }
    }

    private static void showInfo() {
        System.out.println("Collection type: " + flats.getClass().getSimpleName());
        System.out.println("Number of flats: " + flats.size());
    }
}
