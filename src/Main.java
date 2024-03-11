import java.util.*;

public class Main {
    static Manager manager;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command;
        manager = new Manager();

        do {
            command = in.next();
        } while (parseCommand(command));
        manager.exit();
    }

    public static boolean parseCommand(String command) {
        switch (command) {
            case "exit":
                return false;
            case "print":
                manager.printAll();
                return true;
            default:
                return true;
        }
    }
}
