package n2.commands;

import n2.charisma.Dialogue;

public class ByeCommand extends Command {
    @Override
    public boolean execute() {
        Dialogue.printFarewell();
        return false;
    }
}
