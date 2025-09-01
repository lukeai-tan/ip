package redgirls.commands;

import redgirls.intellect.RedGirlsException;
import redgirls.purpose.TaskList;

public class ListCommand extends Command {
    public ListCommand(String input) throws RedGirlsException {
        if (!input.equals("list")) {
            throw RedGirlsException.invalidListCommand();
        }
    }

    @Override
    public void execute() {
        TaskList.printList();
    }
}
