package n2.commands;

import n2.charisma.Dialogue;

/**
 * Represents the {@code bye} command, which terminates the program. <br>
 * When executed, it prints a farewell message and signals that the
 * program should exit.
 */
public class ByeCommand extends Command {
    /**
     * Executes the {@code bye} command. <br>
     * Prints a farewell message via {@link Dialogue#printFarewell()}.
     */
    @Override
    public void execute() {
        Dialogue.printFarewell();
    }

    /**
     * Indicates that this command terminates the program
     *
     * @return always {@code true}
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
