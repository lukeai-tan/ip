package redgirls.intellect;

import redgirls.commands.Command;
import redgirls.commands.DeadlineCommand;
import redgirls.commands.EventCommand;
import redgirls.commands.ListCommand;
import redgirls.commands.TodoCommand;
import redgirls.commands.MarkCommand;

public class Parser {
    public void parseInput(String input) {
        try {
            String command;
            if (input.contains(" ")) {
                command = input.substring(0, input.indexOf(" "));
            } else {
                command = input;
            }
            Command c;
            switch (command) {
            case "list":
                c = new ListCommand(input);
                break;
            case "mark":
            case "unmark":
                c = new MarkCommand(input);
                break;
            case "deadline":
                c = new DeadlineCommand(input);
                break;
            case "event":
                c = new EventCommand(input);
                break;
            case "todo":
                c = new TodoCommand(input);
                break;
            default:
                throw RedGirlsException.unknownCommand();
            }
            c.execute();
        } catch (RedGirlsException e) {
            System.out.println(e.getMessage());
        }
    }
}
