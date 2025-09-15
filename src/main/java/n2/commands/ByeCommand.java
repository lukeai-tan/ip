package n2.commands;

import n2.charisma.Dialogue;

public class ByeCommand extends Command {
    @Override
    public void execute() {
        Dialogue.printFarewell();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
