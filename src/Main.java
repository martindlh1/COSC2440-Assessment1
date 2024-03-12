import model.Claim;
import model.Color;

import java.util.*;

public class Main {

    static Manager manager;
    static String command;
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        manager = new Manager();

        welcome();
        do {
            command = in.next();
        } while (manager.exec(command));
    }

    public static void welcome() {
        System.out.println(Color.BLUE + "Welcome to our insurance claim helper");
        System.out.println("------------------------------------------" + Color.RESET);
        manager.exec("help");
    }
}
