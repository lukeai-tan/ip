package redgirls.intellect;

import redgirls.commands.Command;
import redgirls.commands.DeadlineCommand;
import redgirls.commands.EventCommand;
import redgirls.commands.ListCommand;
import redgirls.commands.TodoCommand;
import redgirls.commands.MarkCommand;

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
            default -> throw RedGirlsException.unknownCommand();
        };
    }
}
