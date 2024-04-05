/**
 * @author <Martin Delahousse - s4034308>
 */

import helper.Printer;

import java.util.Scanner;

public class Main {

    static Manager manager;

    public static void main(String[] args) {
        //Create Scanner & Manager
        Scanner in = new Scanner(System.in);
        manager = new Manager();
        String command;

        //Intercept program stop to properly save data
        Runtime.getRuntime().addShutdownHook(new Thread(() -> manager.shutdown()));

        //Quick function to display welcome information
        welcome();

        //Program loop
        do {
            command = in.nextLine();
        } while (manager.exec(command));
    }

    public static void welcome() {
        Printer.hint("Welcome to our insurance claim helper");
        Printer.hint("------------------------------------------");
        manager.exec("help");
    }
}
