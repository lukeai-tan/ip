package redgirls.commands;

import redgirls.charisma.Dialogue;

public class HelpCommand extends Command {
    @Override
    public boolean execute() {
        Dialogue.printCommandList();
        return true;
    }
}
