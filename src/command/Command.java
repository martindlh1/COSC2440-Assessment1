package command;

public interface Command {
    void help();
    Boolean exec(String[] params);
    boolean verifyParams(String[] params);
}
