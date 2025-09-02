package redgirls.commands;

import redgirls.intellect.RedGirlsException;

public abstract class Command {
    public abstract boolean execute() throws RedGirlsException;
}
