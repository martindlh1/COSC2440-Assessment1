import command.*;
import helper.Printer;

import java.util.*;

public class Manager {
    private final Map<String, Command> commands;

    public Manager() {
        commands = new HashMap<>();
        commands.put("exit", new ExitCommand());
        commands.put("help", new HelpCommand());
        commands.put("printCustomers", new PrintCustomersCommand());
        commands.put("printCustomer", new PrintOneCustomerCommand());
        commands.put("printClaims", new PrintClaimsCommand());
        commands.put("printClaim", new PrintOneClaimCommand());
        commands.put("add", new CreateClaimCommand());
        commands.put("delete", new DeleteCommand());
        commands.put("update", new UpdateCommand());
    }

    public Boolean exec(String command) {
        // Parse command to name & params
        String[] parsedCommand = command.split(" ");
        String commandName = parsedCommand[0];
        String[] params = new String[parsedCommand.length - 1];
        System.arraycopy(parsedCommand, 1, params, 0, parsedCommand.length - 1);

        // Display error message in case of unknown command
        if (!commands.containsKey(commandName)) {
            Printer.error("Unknown command, type 'help' to see available command");
            return true;
        }

        try {
            // Check for --h flag to display information on the command
            Command cmd = commands.get(commandName);
            if (params.length > 0 && params[0].equals("--h")) {
                cmd.help();
                return true;
            }

            // Check parameter before execute command
            if (cmd.verifyParams(params))
                return cmd.exec(params);

            return true;
        } catch (Exception e) {
            Printer.error("ERROR: " + e.getMessage());
            Printer.error("Shutting down program...");
            return false;
        }
    }
}
