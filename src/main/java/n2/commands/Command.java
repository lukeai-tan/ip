package n2.commands;

import n2.intellect.RedGirlsException;

public abstract class Command {
    public abstract boolean execute() throws RedGirlsException;
}
