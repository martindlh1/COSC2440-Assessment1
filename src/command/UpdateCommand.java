package command;

import helper.Printer;
import model.Claim;
import model.Customer;
import repository.ClaimRepository;
import repository.CustomerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UpdateCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'update' command update the selected claim");
        Printer.hint("USAGE:\n\tupdate id:integer option=option_value");
        Printer.hint("OPTIONS:\n\tamount:integer\n\tinsured:integer");
    }

    @Override
    public Boolean exec(String[] params) {
        Number id = Integer.parseInt(params[0]);
        Claim claim = claimRepository.getOne(id);
        if (claim == null) {
            Printer.error("Claim " + id + " not found.");
            return true;
        }
        if (params.length == 1) {
            Printer.result("Nothing to update");
            return true;
        }
        for (int i = 1; i < params.length; i+=1) {
            String param = params[i].split("=")[0];
            String value = params[i].split("=")[1];
            switch (param) {
                case "amount":
                    claim.setAmount(Integer.parseInt(value));
                case "insured":
                    Customer oldInsured = customerRepository.getOne(claim.getInsured());
                    Customer newInsured = customerRepository.getOne(Integer.parseInt(value));
                    oldInsured.removeClaim(claim);
                    newInsured.addClaim(claim);
                    customerRepository.update(oldInsured);
                    customerRepository.update(newInsured);
                    claim.setInsured(Integer.parseInt(value));
            }
        }
        claimRepository.update(claim);
        Printer.result("Claim successfully updated !");
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        if (params.length < 1) {
            Printer.error("Command 'update' take at least 1 parameter, type 'update --h' to get more information.");
            return false;
        }
        try {
            Integer.parseInt(params[0]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'id' must be an integer.");
            return false;
        }
        for (int i = 1; i < params.length; i+=1) {
            String[] parsedParams = params[i].split("=");
            if (parsedParams.length != 2) {
                Printer.error("Invalid option '" + params[i] + "', options must have the format option=option_value, type 'update --h' top get more information.");
                return false;
            }
            String param = parsedParams[0];
            String value = parsedParams[1];
            if (param.isEmpty() || value.isEmpty()) {
                Printer.error("Option or Option Value is missing, type 'update --h' top get more information.");
                return false;
            }
            switch (param) {
                case "amount":
                    try {
                        Integer.parseInt(value);
                        continue;
                    } catch (NumberFormatException e) {
                        Printer.error("Option value for 'amount' must be an integer.");
                        return false;
                    }
                case "insured":
                    try {
                        if (customerRepository.getOne(Integer.parseInt(value)) == null) {
                            Printer.error("Customer not found.");
                            return false;
                        }
                        continue;
                    } catch (NumberFormatException e) {
                        Printer.error("Option value for 'insured' must be an integer.");
                        return false;
                    }
                default:
                    Printer.error("Unknown parameter, type 'update --h' top get more information.");
                    return false;
            }
        }
        return true;

    }
}
