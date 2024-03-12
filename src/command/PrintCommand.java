package command;
import helper.Printer;
import model.Claim;
import repository.ClaimRepository;

public class PrintCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'print' command display a the claims list");
        Printer.hint("USAGE:\n\tprint");
    }

    @Override
    public Boolean exec(String[] params) {
        for (Claim claim : claimRepository.getAll()) {
            Printer.result(claim.toString());
        }
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        return true;
    }
}
