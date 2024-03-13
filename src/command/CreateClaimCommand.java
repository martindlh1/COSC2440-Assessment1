package command;

import helper.Printer;
import model.Claim;
import model.Customer;
import repository.ClaimRepository;
import repository.CustomerRepository;

import java.util.Date;

public class CreateClaimCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'add' command create a new claim");
        Printer.hint("USAGE:\n\tadd amount:integer customerId:integer");
    }

    @Override
    public Boolean exec(String[] params) {
        Number amount = Integer.parseInt(params[0]);
        Number customerId = Integer.parseInt(params[1]);
        Customer customer = customerRepository.getOne(customerId);
        if (customer == null) {
            Printer.error("Customer " + customerId + " not found.");
            return true;
        }
        Claim claim = new Claim(new Date(), customerId, new Date(), null, amount, null);
        customer.addClaim(claim);
        customerRepository.update(customer);
        claimRepository.add(claim);
        Printer.result("Claim " + claim.getId() + " successfully created !");
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        if (params.length < 2) {
            Printer.error("Command 'add' take 2 parameter, type 'add --h' to get more information");
            return false;
        }
        try {
            Integer.parseInt(params[0]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'amount' must be an integer, type 'add --h' to get more information");
            return false;
        }
        try {
            Integer.parseInt(params[1]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'customerId' must be an integer, type 'add --h' to get more information");
            return false;
        }
        return true;
    }
}
