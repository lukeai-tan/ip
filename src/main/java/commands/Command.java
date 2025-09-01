package commands;

import intellect.RedGirlsException;

public abstract class Command {
    public abstract void execute() throws RedGirlsException;
}
