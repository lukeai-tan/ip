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
        String content = extractEventContent(input);
        String[] parts = extractDescriptionAndTimes(content);
        String description = parts[0];
        String from = DateConverter.handleDateTimeParsing(parts[1]);
        String to = DateConverter.handleDateTimeParsing(parts[2]);

        validateEventParts(description, from, to);
        eventTask = new EventTask(description, from, to);
    }

    /**
     * Parses the input to separate the "event" command from the input string
     *
     * @param input raw input string
     * @return string without "event" command
     * @throws RedGirlsException if the event command is not correctly defined
     */
    private String extractEventContent(String input) throws RedGirlsException {
        String trimmed = input.trim();
        if (trimmed.equals("event")) {
            throw RedGirlsException.invalidEventTask();
        }
        return trimmed.substring(trimmed.indexOf(" ") + 1);
    }

    /**
     * Parses the input to extract the description, from and to strings.
     *
     * @param content raw string containing event task parameters
     * @return String type array containing {@code description}, {@code from} and {@code to} strings
     */
    private String[] extractDescriptionAndTimes(String content) {
        final String FROM = "/from";
        final String TO = "/to";
        int fromIndex = content.indexOf(FROM);
        int toIndex = content.indexOf(TO);

        String description, fromRaw, toRaw;
        if (fromIndex < toIndex) {
            description = content.substring(0, fromIndex).trim();
            fromRaw = content.substring(fromIndex + FROM.length(), toIndex).trim();
            toRaw = content.substring(toIndex + TO.length()).trim();
        } else {
            description = content.substring(0, toIndex).trim();
            toRaw = content.substring(toIndex + TO.length(), fromIndex).trim();
            fromRaw = content.substring(fromIndex + FROM.length()).trim();
        }

        return new String[]{description, fromRaw, toRaw};
    }

    /**
     * Validates that the description, from and to strings are in valid form.
     * Otherwise, the event task is invalid.
     *
     * @param description description of the event task
     * @param from starting time/point of the event
     * @param to ending time/point of the event
     * @throws RedGirlsException if the {@code description}, {@code from} or {@code to} strings are of invalid format
     */
    private void validateEventParts(String description, String from, String to) throws RedGirlsException {
        if (description.isEmpty()) {
            throw RedGirlsException.invalidEventTask();
        }
        if (from.isEmpty() || to.isEmpty()) {
            throw RedGirlsException.missingEventTime();
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
