package n2.commands;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

/**
 * Represents the {@code list} command, which displays all tasks currently
 * stored in the {@link TaskList}.
 *
 * <p>When executed, it prints all tasks in order, along with their completion status.</p>
 */
public class ListCommand extends Command {
    /**
     * Creates a new {@code ListCommand} and validates the input.
     * <p>
     * The input must exactly match {@code "list"}.
     * </p>
     *
     * @param input raw user input
     * @throws RedGirlsException if the input is not exactly "list"
     */
    public ListCommand(String input) throws RedGirlsException {
        if (!input.equals("list")) {
            throw RedGirlsException.invalidListCommand();
        }
    }

    /**
     * Executes the {@code list} command.
     * <p>
     * Prints all tasks in {@link TaskList} to standard output.
     * </p>
     */
    @Override
    public void execute() {
        TaskList.printList();
    }

    /**
     * Indicates that this command does not terminate the program.
     *
     * @return always {@code false}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
