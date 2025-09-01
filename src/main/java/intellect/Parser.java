package intellect;

import commands.Command;
import commands.DeadlineCommand;
import commands.EventCommand;
import commands.TodoCommand;
import commands.MarkCommand;
import purpose.TaskList;

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
                TaskList.printList();
                break;
            case "mark":
            case "unmark":
                c = new MarkCommand(input);
                c.execute();
                break;
            case "deadline":
                c = new DeadlineCommand(input);
                c.execute();
                break;
            case "event":
                c = new EventCommand(input);
                c.execute();
                break;
            case "todo":
                c = new TodoCommand(input);
                c.execute();
                break;
            default:
                throw RedGirlsException.unknownCommand();
            }
        } catch (RedGirlsException e) {
            System.out.println(e.getMessage());
        }
    }
}
