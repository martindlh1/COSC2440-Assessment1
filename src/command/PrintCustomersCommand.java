/**
 * @author <Martin Delahousse - s4034308>
 */

package command;

import helper.Printer;
import model.Customer;
import repository.CustomerRepository;

public class PrintCustomersCommand implements Command {
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    public void help() {
        Printer.hint("The 'printCustomers' command display a the customers list");
        Printer.hint("USAGE:\n\tprintCustomers");
    }

    @Override
    public Boolean exec(String[] params) {
        for (Customer customer : customerRepository.getAll()) {
            Printer.result(customer.toString());
        }
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        return true;
    }
}
