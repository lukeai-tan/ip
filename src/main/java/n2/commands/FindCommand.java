package n2.commands;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

/**
 * Represents the {@code find} command, which searches for tasks containing
 * a specific keyword in their descriptions.
 *
 * <p>When executed, it prints all matching tasks via {@link TaskList#printFilteredList(String)}</p>
 */
public class FindCommand extends Command {
    /**
     * The keyword used to filter tasks.
     */
    private String keyword;

    /**
     * Creates a new {@code FindCommand} by parsing the raw user input. <br>
     * Extracts the keyword used for searching tasks.
     *
     * @param input raw user input (e.g. "find homework")
     * @throws RedGirlsException if the keyword is missing, empty or whitespace
     */
    public FindCommand(String input) throws RedGirlsException {
        handleFindKeywordParsing(input);
    }

    /**
     * Parses the user input to extract the search keyword. <br>
     * Expects the input to have the format: {@code find <keyword>}.
     *
     * @param input raw input string
     * @throws RedGirlsException if invalid keyword is provided
     */
    public void handleFindKeywordParsing(String input) throws RedGirlsException {
        String[] parts = input.split("\\s+", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw RedGirlsException.invalidKeyword();
        }
        keyword = parts[1].trim();
    }

    /**
     * Executes the {@code find} command. <br>
     * Prints all tasks containing the specified keyword.
     */
    @Override
    public void execute() {
        TaskList.printFilteredList(keyword);
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
