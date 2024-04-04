/**
 * @author <Martin Delahousse - s4034308>
 */

package command;

import helper.Printer;
import model.Customer;
import repository.CustomerRepository;

public class PrintOneCustomerCommand implements Command {
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    @Override
    public void help() {
        Printer.hint("The 'printCustomer' command display one detailed customer found by it's id");
        Printer.hint("USAGE:\n\tprintCustomer id:integer");
    }

    @Override
    public Boolean exec(String[] params) {
        Number id = Integer.parseInt(params[0]);
        Customer customer = customerRepository.getOne(id);
        if (customer == null) {
            Printer.error("Customer " + id + " not found.");
            return true;
        }
        Printer.result(customer.toDetailedString());
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        if (params.length < 1) {
            Printer.error("Command 'printCustomer' take 1 parameter, type 'printCustomer --h' to get more information.");
            return false;
        }
        try {
            Integer.parseInt(params[0]);
        } catch (NumberFormatException e) {
            Printer.error("Parameter 'id' must be an integer.");
            return false;
        }
        return true;
    }
}
