package n2.commands;

import static n2.charisma.Dialogue.redGirlsPrint;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

/**
 * Represents the {@code mark} and {@code unmark} commands,
 * which update the completion status of a task in {@link TaskList}.
 *
 * <p>Usage:
 * <ul>
 *     <li>{@code mark <index>} - marks the task at the given index as done</li>
 *     <li>{@code unmark <index>} - marks the task at the given index as not done</li>
 * </ul>
 * </p>
 */
public class MarkCommand extends Command {
    /**
     * The command keyword ("mark" or "unmark").
     */
    private String command;

    /**
     * The index of the task to mark/unmark (0-indexing)
     */
    private int index;

    /**
     * Creates a new {@code MarkCommand} by parsing user input.
     * <p>
     * Expects input in the format: {@code mark <index>} or {@code unmark <index>}.
     * </p>
     *
     * @param input raw user input
     * @throws RedGirlsException if the input is invalid or the index is out of range
     */
    public MarkCommand(String input) throws RedGirlsException {
        handleMarkInput(input);
    }

    /**
     * Parses the input string to extract the command and task index.
     *
     * @param input raw inputs string
     * @throws RedGirlsException if the input is malformed or the index is invalid
     */
    public void handleMarkInput(String input) throws RedGirlsException {
        String[] parts = input.split("\\s+");
        if (parts.length != 2) {
            if(parts.length < 2) {
                throw RedGirlsException.invalidMark();
            } else {
                throw RedGirlsException.invalidTaskIndex();
            }
        }

        command = parts[0];

        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            redGirlsPrint("Your fragment index... unreadable. Chaos in the pattern.");
            return;
        }

        if (index < 0 || index >= TaskList.getSize()) {
            throw RedGirlsException.invalidTaskIndex();
        }
    }

    /**
     * Executes the {@code mark} or {@code unmark} command.
     * <p>
     * Updates the status of the task at the specified index.
     * </p>
     *
     * @throws RedGirlsException if marking/unmarking fails
     */
    @Override
    public void execute() throws RedGirlsException {
        switch (command) {
            case "mark" -> TaskList.markTaskEntry(index);
            case "unmark" -> TaskList.unmarkTaskEntry(index);
            default -> redGirlsPrint("Unknown command. Reality distorts. " +
                    "Are you this world's Singularity?");
        }
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
