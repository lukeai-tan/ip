package n2.commands;

import static n2.charisma.Dialogue.redGirlsPrint;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

/**
 * Represents the {@code delete} command, which removes a task
 * from {@link TaskList} based on its index.
 *
 * <p>Usage: {@code delete <index>}.</p>
 */
public class DeleteCommand extends Command {
    /**
     * The index of the task to delete (0-indexing)
     */
    private int index;

    /**
     * Creates a new {@code DeleteCommand} by parsing the raw user input.
     * <p>
     * Extracts the task index to be deleted.
     * </p>
     *
     * @param input raw user input
     * @throws RedGirlsException if the input is malformed or the index is invalid
     */
    public DeleteCommand(String input) throws RedGirlsException {
        handleDeleteTaskInput(input);
    }

    /**
     * Parses the input string to extract the task index.
     * <p>
     * Validates that the index is a valid integer within bounds.
     * </p>
     *
     * @param input raw input string
     * @throws RedGirlsException if the input is malformed or the index is invalid
     */
    public void handleDeleteTaskInput(String input) throws RedGirlsException {
        String[] parts = input.split("\\s+");
        if (parts.length != 2) {
            throw RedGirlsException.invalidDelete();
        }

        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw RedGirlsException.invalidDelete();
        }

        if (index < 0 || index >= TaskList.getSize()) {
            throw RedGirlsException.invalidTaskIndex();
        }
    }

    /**
     * Executes the {@code delete} command.
     * <p>
     * Removes the task at the specified index from {@link TaskList}.
     * </p>
     *
     * @throws RedGirlsException if index is invalid
     */
    @Override
    public void execute() throws RedGirlsException {
        TaskList.deleteTask(index);
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
