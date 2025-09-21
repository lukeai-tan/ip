package n2.intellect;

import n2.commands.ByeCommand;
import n2.commands.Command;
import n2.commands.DeadlineCommand;
import n2.commands.DeleteCommand;
import n2.commands.EventCommand;
import n2.commands.FindCommand;
import n2.commands.HelpCommand;
import n2.commands.ListCommand;
import n2.commands.TodoCommand;
import n2.commands.MarkCommand;

/**
 * Parses raw user input into executable {@link Command} objects. <br>
 * The {@code Parser} is responsible for identifying the command keyword,
 * validating the input and constructing the instance of the
 * corresponding command.
 *
 * <p>Supported commands include:
 * <ul>
 *     <li>{@code list} - displays all tasks</li>
 *     <li>{@code mark}/{@code unmark} - marks or unmarks a task</li>
 *     <li>{@code deadline} - creates a {@link n2.purpose.DeadlineTask}</li>
 *     <li>{@code event} - creates an {@link n2.purpose.EventTask}</li>
 *     <li>{@code todo} - creates a {@link n2.purpose.TodoTask}</li>
 *     <li>{@code delete} - removes a task</li>
 *     <li>{@code find} - searches tasks by keyword</li>
 *     <li>{@code help} - shows available commands</li>
 *     <li>{@code bye} - exits the program</li>
 * </ul>
 * </p>
 */
public class Parser {
    /**
     * Parses the given input string and returns the corresponding {@link Command}. <br>
     * The first token (before the first space) is treated as the command keyword.
     *
     * @param input raw user input
     * @return a {@link Command} corresponding to the input
     * @throws RedGirlsException if the input is empty, blank or unrecognized
     */
    public Command parseInput(String input) throws RedGirlsException {
        if (input == null || input.isBlank()) {
            throw RedGirlsException.emptyInput();
        }
        String command = input.split(" ")[0];
        return switch (command) {
            case "list" -> new ListCommand(input);
            case "mark", "unmark" -> new MarkCommand(input);
            case "deadline" -> new DeadlineCommand(input);
            case "event" -> new EventCommand(input);
            case "todo" -> new TodoCommand(input);
            case "delete" -> new DeleteCommand(input);
            case "find" -> new FindCommand(input);
            case "bye" -> new ByeCommand();
            case "help" -> new HelpCommand();
            default -> throw RedGirlsException.unknownCommand();
        };
    }
}
