import helper.DataCreator;
import helper.Printer;
import model.Customer;
import model.CustomerType;
import model.InsuranceCard;
import repository.CustomerRepository;
import repository.InsuranceCardRepository;

import java.time.LocalDate;
import java.util.*;

public class Main {

    static Manager manager;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        manager = new Manager();
        String command;

        //Intercept program stop to properly save data
        Runtime.getRuntime().addShutdownHook(new Thread(() -> manager.shutdown()));

        welcome();
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
