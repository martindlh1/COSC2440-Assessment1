import model.Claim;

import java.util.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static Manager manager;
    static String command;
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        manager = new Manager();

        System.out.println("Welcome to our command line insurance claim helper");
        help();
        do {
            command = in.next();
        } while (parseCommand());
        manager.exit();
    }

    public static boolean parseCommand() {
        return switch (command) {
            case "exit" -> false;
            case "help" -> help();
            case "print" -> printAll();
            case "add" -> add();
            case "clear" -> clearScreen();
            case "delete" -> delete();
            default -> unknownCommand();
        };
    }

    public static boolean help() {
        System.out.println("""
                USAGE:
                \thelp\t->\tdisplay available commands
                \texit\t->\texit the program
                \tprint\t->\tdisplay the claims list
                \tadd\t\t->\tstart the claim creation process""");
        return true;
    }

    public static boolean printAll() {
        for (Claim claim : manager.getAll()) {
            System.out.println(claim.toString());
        }
        return true;
    }

    public static boolean delete() {
        List<Claim> claims = manager.getAll();
        for (int i = 0; i < claims.size(); i++) {
            System.out.println(ANSI_RED + i + ANSI_RESET);
            System.out.println(claims.get(i).toString());
        }
        System.out.println("Please select a claim:");
        int selection = Integer.parseInt(in.next());
        while (selection > claims.size()) {
            System.out.println("Selection out of range, please select again:");
            selection = Integer.parseInt(in.next());
        }
        System.out.println("Are you sure you want to delete this claim ?");
        System.out.println(claims.get(selection).toString());
        System.out.println("Y/N:");
        String answer = in.next();
        while (answer.toCharArray()[0] == 'Y' || answer.toCharArray()[0] == 'N') {
            System.out.println("Y/N:");
            answer = in.next();
        }
        if (answer.toCharArray()[0] == 'N')
            return true;
        manager.delete(claims.get(selection));
        return true;
    }

    public static boolean add() {
        System.out.println("Enter the amount:");
        Number amount = Integer.parseInt(in.next());
        manager.add(new Claim(new Date(), null, new Date(), null, amount, null));
        return true;
    }

    public static boolean unknownCommand() {
        System.out.println("Unknown command, type help to see available command");
        return true;
    }

    public static boolean clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return true;
    }
}
