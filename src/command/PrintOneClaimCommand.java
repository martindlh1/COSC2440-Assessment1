package command;

import helper.Printer;
import model.Claim;
import repository.ClaimRepository;

public class PrintOneClaimCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'printClaim' command display one claim found by it's id");
        Printer.hint("USAGE:\n\tprint id:integer");
    }

    @Override
    public Boolean exec(String[] params) {
        Number id = Integer.parseInt(params[0]);
        Claim claim = claimRepository.getOne(id);
        if (claim == null) {
            Printer.error("Claim not found");
            return true;
        }
        Printer.result(claim.toDetailedString());
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        if (params.length < 1) {
            Printer.error("Command 'printClaim' take 1 parameter, type 'printClaim --h' to get more information");
            return false;
        }
        try {
            Integer.parseInt(params[0]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'id' must be an integer");
            return false;
        }
        return true;
    }
}
