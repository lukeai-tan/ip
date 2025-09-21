package n2.commands;

import n2.intellect.RedGirlsException;

/**
 * Represents an abstract command in the system. <br>
 * Each user instruction (e.g., {@code list}, {@code todo}, {@code delete})
 * is encapsulated as a {@code Command} object that defines specific behavior.
 *
 * <p>Subclasses must implement:
 * <ul>
 *     <li>{@link #execute()} - performs the action defined by the command</li>
 *     <li>{@link #isExit()} - indicates whether the command ends the program</li>
 * </ul>
 * </p>
 *
 * <p>This design follows the <b>Command Pattern</b>,
 * allowing user inputs to be decoupled from their execution logic.</p>
 */
public abstract class Command {
    /**
     * Executes the action associated with this command.
     *
     * @throws RedGirlsException if an error occurs during execution
     */
    public abstract void execute() throws RedGirlsException;

    /**
     * Determines whether this command signals program termination.
     *
     * @return {@code true} if the command exits the program, {@code false} otherwise
     */
    public abstract boolean isExit();
}
