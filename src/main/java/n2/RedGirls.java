package n2;

import java.util.Scanner;

import n2.charisma.Dialogue;
import n2.commands.Command;
import n2.intellect.Parser;
import n2.intellect.RedGirlsException;
import n2.memory.MemoryArchive;
import n2.purpose.TaskList;

/**
 * Main entry point for the RedGirls chatbot.
 * <p>
 * This class handles initialization, user input parsing, command execution and task persistence.
 * It continuously listens for user inputs, parsing them into relevant commands and executing them
 * until the ByeCommand is called to terminate the program.
 * </p>
 * <p>
 * The RedGirls chatbot utilizes the following packages:
 * <ul>
 *     <li>{@link n2.charisma.Dialogue}: For user interaction and dialogue messages.</li>
 *     <li>{@link n2.commands.Command}: For executing commands.</li>
 *     <li>{@link n2.intellect.Parser}: For parsing raw user input into valid commands.</li>
 *     <li>{@link n2.memory.MemoryArchive}: For handling persistence of tasks to local storage.</li>
 * </ul>
 * </p>
 */
public class RedGirls {
    /**
     * Initializes the RedGirls system
     * <p>
     * Displays boot sequence and greeting, and enters a loop to read user input.
     * Commands are parsed, executed, and the task list is saved after each command.
     * Loop continues until an exit command (e.g. ByeCommand) is issued.
     * </p>
     */
    public static void initRedGirl() {
        Dialogue.printBootSequence();
        Dialogue.printGreeting();
        boolean isExit = false;
        try (Scanner sc = new Scanner(System.in)) {
            Parser parser = new Parser();
            while (!isExit) {
                String s = sc.nextLine();
                try {
                    Command c = parser.parseInput(s);
                    c.execute();
                    isExit = c.isExit();
                    MemoryArchive.save(TaskList.getTaskList());
                } catch (RedGirlsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Application entry point
     * <p>
     * Activates the chatbot by calling the {@link #initRedGirl()} method/
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        initRedGirl();
    }
}
