package n2.commands;

import n2.charisma.Dialogue;

/**
 * Represents the {@code help} command, which displays a list
 * of available commands and their descriptions.
 * <p>
 * When executed, it prints the command list via {@link Dialogue#printCommandList()}.
 * </p>
 */
public class HelpCommand extends Command {
    /**
     * Executes the {@code help} command.
     * <p>
     * Prints the list of supported commands and their usage.
     * </p>
     */
    @Override
    public void execute() {
        Dialogue.printCommandList();
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
