package n2.commands;

import n2.charisma.Dialogue;

public class HelpCommand extends Command {
    @Override
    public boolean execute() {
        Dialogue.printCommandList();
        return true;
    }
}
