package command;

import helper.Printer;
import repository.ClaimRepository;
import repository.CustomerRepository;

public class ExitCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'exit' command exit properly the program after saving data");
        Printer.hint("USAGE:\n\texit");
    }

    @Override
    public Boolean exec(String[] params) {
        claimRepository.save();
        customerRepository.save();
        Printer.result("Data successfully save, goodbye !");
        return false;
    }

    @Override
    public boolean verifyParams(String[] params) {
        return true;
    }
}
