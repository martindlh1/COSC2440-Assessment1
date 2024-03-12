package command;

import helper.Printer;

public class HelpCommand implements Command {
    @Override
    public void help() {
        Printer.hint("The 'help' command display a brief description of available commands");
        Printer.hint("USAGE:\n\thelp");
    }

    @Override
    public Boolean exec(String[] params) {
        Printer.hint("""
                USAGE:
                \tCOMMAND\t\t\tPARAMS\t\t\tDESCRIPTION
                \thelp\t\t\t\t\t\t\tdisplay available commands
                \texit\t\t\t\t\t\t\texit the program
                \tprint\t\t\t\t\t\t\tdisplay the claims list
                \tprintOn\t\t\tid:int\t\t\tdisplay one claim (find by id)
                \tadd\t\t\t\tamount:int\t\tcreate a new claim
                Add --h flags after a command to get more information""");
        return true;
    }

    @Override
    public boolean verifyParams(String[] params) {
        return true;
    }
}
