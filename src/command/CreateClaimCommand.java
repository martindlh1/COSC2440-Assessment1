package command;

import helper.Printer;
import model.Claim;
import repository.ClaimRepository;

import java.util.Date;

public class CreateClaimCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'add' command create a new claim");
        Printer.hint("USAGE:\n\tadd amount:integer");
    }

    @Override
    public Boolean exec(String[] params) {
        Number amount = Integer.parseInt(params[0]);
        claimRepository.add(new Claim(new Date(), null, new Date(), null, amount, null));
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        if (params.length < 1) {
            Printer.error("Command 'add' take 1 parameter, type 'add --h' to get more information");
            return false;
        }
        try {
            Integer.parseInt(params[0]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'amount' must be an integer, type 'add --h' to get more information");
            return false;
        }
        return true;
    }
}
