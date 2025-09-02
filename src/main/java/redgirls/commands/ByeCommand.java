package redgirls.commands;

import redgirls.charisma.Dialogue;

public class ByeCommand extends Command {
    @Override
    public boolean execute() {
        Dialogue.printFarewell();
        return false;
    }
}
