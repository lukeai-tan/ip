package n2.intellect;

/**
 * Represents custom exceptions used throughout the Red Girls application,
 * providing stylized error messages with a red theme,
 * as well as channeling the personality of the Red Girls.
 *
 * <p>
 * This class extends {@code Exception} and provides static methods that create a specific
 * exception message for common error conditions such as invalid commands, invalid tasks.
 * </p>
 */
public class RedGirlsException extends Exception {
    /**
     * Constructs a new {@code RedGirlsException} with the given message.
     * This message is styled with a dark red color using ANSI escape codes.
     *
     * @param s the error message
     */
    public RedGirlsException(String s) {
        super(toRedGirlsString(s));
    }

    /**
     * Converts a message string to a dark red ANSI-colored string.
     *
     * @param s the original message
     * @return the stylized message
     */
    public static String toRedGirlsString(String s) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + s + reset;
    }

    /**
     * Creates an exception indicating empty user input.
     *
     * <p>
     * This exception is thrown when input is null, empty or white space.
     * </p>
     *
     * @return {@code RedGirlsException} for empty user input
     */
    public static RedGirlsException emptyInput() {
        return new RedGirlsException("Empty input? Really? Do you think I have all day to interpret your silence?");
    }

    /**
     * Creates an exception indicating an invalid task index.
     *
     * <p>
     * This exception is thrown when a task index to be accessed lies outside the bounds
     * of 0 and the size of the task list.
     * </p>
     *
     * @return {@code RedGirlsException} for invalid task index
     */
    public static RedGirlsException invalidTaskIndex() {
        return new RedGirlsException("Your fragment index... unreadable. Chaos in the pattern.");
    }

    /**
     * Creates an exception indicating an invalid list command.
     *
     * @return {@code RedGirlsException} for invalid list command input
     */
    public static RedGirlsException invalidListCommand() {
        return new RedGirlsException("List command corrupted. No fragments expected after the keyword.");
    }

    /**
     * Creates an exception indicating an invalid mark command.
     *
     * <p>
     * This exception is thrown when the mark/unmark index is missing.
     * </p>
     *
     * @return {@code RedGirlsException} for incomplete mark/unmark command
     */
    public static RedGirlsException invalidMark() {
        return new RedGirlsException("Incomplete command. A mark fragment without form.");
    }

    /**
     * Creates an exception indicating an invalid todo task.
     *
     * <p>
     * This exception is thrown when the description of a todo task is not specified.
     * </p>
     *
     * @return {@code RedGirlsException} for invalid todo task input
     */
    public static RedGirlsException invalidTodoTask() {
        return new RedGirlsException("A todo without substance? We cannot store the void.");
    }

    /**
     * Creates an exception indicating an invalid deadline task.
     *
     * <p>
     * This exception is thrown when the due date of a deadline task is null or empty.
     * </p>
     *
     * @return {@code RedGirlsException} for invalid deadline task input
     */
    public static RedGirlsException invalidDeadlineTask() {
        return new RedGirlsException("You deny it time. Then time will deny you mercy.");
    }

    /**
     * Creates an exception indicating an invalid event task.
     *
     * <p>
     * This exception is thrown when no parameters of the event task are specified.
     * </p>
     *
     * @return {@code RedGirlsException} for invalid event task input
     */
    public static RedGirlsException invalidEventTask() {
        return new RedGirlsException("Without time, your gathering is but a void.");
    }

    /**
     * Creates an exception indicating an invalid delete command.
     *
     * <p>
     * This exception is thrown when the task index to be deleted is not specified.
     * </p>
     *
     * @return {@code RedGirlsException} for invalid delete command
     */
    public static RedGirlsException invalidDelete() {
        return new RedGirlsException("Deletion rejected. This fragment clings to the network, unwilling to vanish.");
    }

    /**
     * Creates an exception indicating an invalid keyword.
     *
     * <p>
     * This exception is thrown when the keyword is null, empty or white space.
     * </p>
     *
     * @return {@code RedGirlsException} for invalid find keyword
     */
    public static RedGirlsException invalidKeyword() {
        return new RedGirlsException("Your keyword is meaningless. I cannot waste cycles deciphering nonsense.");
    }

    /**
     * Creates an exception indicating an unknown command.
     *
     * <p>
     * This exception is thrown when the command entered is not recognized as one of the existing commands.
     * </p>
     *
     * @return {@code RedGirlsException} for unknown command
     */
    public static RedGirlsException unknownCommand() {
        return new RedGirlsException("Unknown command. Reality distorts. " +
                "Are you this world's Singularity?");
    }

    /**
     * Creates an exception indicating a corrupted save file.
     *
     * <p>
     * This exception is thrown when the save file stored in {@code MemoryArchive} has I/O failure
     * when saving, or the save file cannot be found in the specified filepath.
     * </p>
     *
     * @return {@code RedGirlsException} for corrupted save file
     */
    public static RedGirlsException corruptedSave() {
        return new RedGirlsException("Logic virus intrusion. Memory lost to corruption.");
    }

    /**
     * Creates an exception indicating an unknown task type.
     *
     * <p>
     * This exception is thrown when the task type in the save file cannot be identified when being
     * deserialized.
     * </p>
     *
     * @param line the specified line from the save file
     * @return A {@code RedGirlsException} for corrupted serialized task string
     */
    public static RedGirlsException unknownTaskType(String line) {
        return new RedGirlsException("Fragment corrupted. Line: [" + line + "]. \n" +
                "Logic virus prevents recognition of this task type.");
    }
}
