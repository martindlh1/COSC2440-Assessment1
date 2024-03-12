package command;

import helper.Printer;
import repository.ClaimRepository;

public class ExitCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'exit' command exit properly the program after saving data");
        Printer.hint("USAGE:\n\texit");
    }

    @Override
    public Boolean exec(String[] params) {
        claimRepository.save();
        Printer.result("Data successfully save, goodbye !");
        return false;
    }

    @Override
    public boolean verifyParams(String[] params) {
        return true;
    }
}
