package n2.intellect;

import n2.commands.ByeCommand;
import n2.commands.Command;
import n2.commands.DeadlineCommand;
import n2.commands.DeleteCommand;
import n2.commands.EventCommand;
import n2.commands.HelpCommand;
import n2.commands.ListCommand;
import n2.commands.TodoCommand;
import n2.commands.MarkCommand;

public class Parser {
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
            case "bye" -> new ByeCommand();
            case "help" -> new HelpCommand();
            default -> throw RedGirlsException.unknownCommand();
        };
    }
}
