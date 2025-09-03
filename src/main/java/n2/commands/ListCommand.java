package n2.commands;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

public class ListCommand extends Command {
    public ListCommand(String input) throws RedGirlsException {
        if (!input.equals("list")) {
            throw RedGirlsException.invalidListCommand();
        }
    }

    @Override
    public boolean execute() {
        TaskList.printList();
        return true;
    }
}
