package n2.commands;

import n2.intellect.DateConverter;
import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;
import n2.purpose.EventTask;

/**
 * Represents the {@code event} command, which adds an {@link EventTask}
 * to the {@link TaskList} with a specific start and end time or point.
 *
 * <p>Usage: {@code event <description> /from <start> /to <end>}.</p>
 */
public class EventCommand extends Command {
    /**
     * The {@link EventTask} created from user input.
     */
    private EventTask eventTask;

    /**
     * Creates a new {@code EventCommand} by parsing the raw user input.
     * <p>
     * Extracts the description, start time, and end time for the event.
     * </p>
     *
     * @param input raw user input
     * @throws RedGirlsException if the input is malformed or missing required start or end times
     */
    public EventCommand(String input) throws RedGirlsException {
        handleEventTaskInput(input);
    }

    /**
     * Parses the input to extract the event description, start time and end time.
     * <p>
     * Uses {@link DateConverter#handleDateTimeParsing(String)} to normalize times into
     * a standardized format.
     * </p>
     *
     * @param input raw input string
     * @throws RedGirlsException if the event description or times are missing or invalid
     */
    private void handleEventTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/from", 2);
        String description = parts[0].trim();

        if (parts.length < 2) {
            throw RedGirlsException.invalidEventTask();
        }
        String[] timeParts = parts[1].split("/to", 2);
        String from = timeParts[0].trim();
        String to = (timeParts.length > 1) ? timeParts[1].trim() : null;

        from = DateConverter.handleDateTimeParsing(from);
        to = DateConverter.handleDateTimeParsing(to);

        if (to != null && !to.isEmpty()) {
            eventTask = new EventTask(description, from, to);
        } else {
            throw RedGirlsException.missingEventEndTime();
        }
    }

    /**
     * Executes the {@code event} command.
     * <p>Adds the {@link EventTask} to {@link TaskList} and prints a confirmation message.</p>
     */
    @Override
    public void execute() {
        TaskList.addTask(eventTask);
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
