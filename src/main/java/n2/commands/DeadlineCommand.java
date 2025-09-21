package n2.commands;

import n2.intellect.DateConverter;
import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;
import n2.purpose.DeadlineTask;

/**
 * Represents the {@code deadline} command, which adds a {@link DeadlineTask}
 * to the {@link TaskList} with a specific due date or time.
 *
 * <p>Usage: {@code deadline <description> /by <deadline>}.</p>
 */
public class DeadlineCommand extends Command {
    /**
     * The {@link DeadlineTask} created from user input.
     */
    private DeadlineTask deadlineTask;

    /**
     * Creates a new {@code DeadlineCommand} by parsing the raw user input.
     *
     * <p>
     * Extract the description and deadline for the task.
     * </p>
     *
     * @param input raw user input
     * @throws RedGirlsException if the input is malformed or missing a valid deadline
     */
    public DeadlineCommand(String input) throws RedGirlsException {
        handleDeadlineTaskInput(input);
    }

    /**
     * Parses the input to extract the task description and deadline.
     * Uses {@link DateConverter#handleDateTimeParsing(String)} to normalize times into
     * a standardized format.
     *
     * @param input raw input string
     * @throws RedGirlsException if the deadline is missing or invalid
     */
    private void handleDeadlineTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/by", 2);
        String description = parts[0].trim();
        String deadline = (parts.length > 1) ? parts[1].trim() : null;

        deadline = DateConverter.handleDateTimeParsing(deadline);

        if (deadline != null && !deadline.isEmpty()) {
            deadlineTask = new DeadlineTask(description, deadline);
        } else {
            throw RedGirlsException.invalidDeadlineTask();
        }
    }

    /**
     * Executes the {@code deadline} command.
     * <p>
     * Adds the {@link DeadlineTask} to {@link TaskList} and prints a confirmation message.
     * </p>
     */
    @Override
    public void execute() {
        TaskList.addTask(deadlineTask);
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
