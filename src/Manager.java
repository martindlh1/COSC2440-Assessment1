import com.google.gson.Gson;
import model.Claim;
import model.Customer;
import java.util.*;
import java.util.function.Function;

public class Manager {
    private final Map<String, Function<Void, Boolean>> commands;
    private final ClaimRepository claimRepository;
    private List<Customer> customers;

    public Manager() {
        commands = new HashMap<>();
        commands.put("exit", this::exit);
        commands.put("help", this::help);
        commands.put("print", this::printClaims);
        claimRepository = new ClaimRepository();
    }

    public Boolean exec(String command) {
        try {
            return commands.get(command).apply(null);
        } catch (NullPointerException e) {
            System.out.println("Unknown command, type help to see available command");
            return true;
        }
    }

    private Boolean exit(Void unused) {
        claimRepository.save();
        return false;
    }

    private Boolean help(Void unused) {
        System.out.println("""
                USAGE:
                \thelp\t->\tdisplay available commands
                \texit\t->\texit the program
                \tprint\t->\tdisplay the claims list
                \tadd\t\t->\tstart the claim creation process""");
        return true;
    }

    private Boolean printClaims(Void unused) {
        for (Claim claim : claimRepository.getAll()) {
            System.out.println(claim.toString());
        }
        return true;
    }


}
