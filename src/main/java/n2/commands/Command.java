package n2.commands;

import n2.intellect.RedGirlsException;

public abstract class Command {
    public abstract void execute() throws RedGirlsException;

    public abstract boolean isExit();
}
