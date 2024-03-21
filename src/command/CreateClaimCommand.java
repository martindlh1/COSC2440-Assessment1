package command;

import helper.Printer;
import model.BankInfo;
import model.Claim;
import model.Customer;
import model.CustomerType;
import repository.ClaimRepository;
import repository.CustomerRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateClaimCommand implements Command {
    private final ClaimRepository claimRepository = ClaimRepository.getInstance();
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'add' command create a new claim");
        Printer.hint("USAGE:\n\tadd customerId:integer amount:integer exam_date:mm/dd/yyyy bank_info:bankName/holderName/cardNumber");
    }

    @Override
    public Boolean exec(String[] params) {
        Number amount = Integer.parseInt(params[1]);
        Number customerId = Integer.parseInt(params[0]);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        try {
            date = df.parse(params[2]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Customer customer = customerRepository.getOne(customerId);
        if (customer == null) {
            Printer.error("Customer " + customerId + " not found.");
            return true;
        }
        String[] bankInfoParams = params[2].split("/");
        BankInfo bankInfo = new BankInfo(bankInfoParams[0], bankInfoParams[1], Integer.parseInt(bankInfoParams[2]));
        Claim claim = new Claim(customer, date, null, amount, bankInfo);
        customer.addClaim(claim);
        customerRepository.update(customer);
        claimRepository.add(claim);
        Printer.result("Claim " + claim.getId() + " successfully created !");
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        if (params.length < 4) {
            Printer.error("Command 'add' take 4 parameter, type 'add --h' to get more information.");
            return false;
        }

        try {
            Number id = Integer.parseInt(params[0]);
            Customer customer = customerRepository.getOne(id);
            if (customer == null) {
                Printer.error("Customer " + id + " not found.");
                return false;
            }
            if (customer.getType() != CustomerType.DEPENDENT) {
                Printer.error("Customer " + id + " is a policy owner not a dependent.");
                return false;
            }
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'customerId' must be an integer, type 'add --h' to get more information.");
            return false;
        }
        try {
            Integer.parseInt(params[1]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'amount' must be an integer, type 'add --h' to get more information.");
            return false;
        }
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse(params[2]);
        } catch (ParseException e) {
            Printer.error("Parameter 'exam_date' must follow the format 'mm/dd/yyyy', type 'add --h' to get more information.");
            return false;
        }
        try {
            String[] bankInfo = params[3].split("/");
            if (bankInfo.length != 3) {
                Printer.error("Parameter 'bank_info' must follow the format 'bankName/holderName/cardNumber', type 'add --h' to get more information.");
                return false;
            }
            Integer.parseInt(bankInfo[2]);
        } catch (NumberFormatException e) {
            Printer.error("3th part of parameter 'bank_info' (cardNumber) must be an integer, type 'add --h' to get more information.");
            return false;
        }
        return true;
    }
}
