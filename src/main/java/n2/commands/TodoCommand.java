package n2.commands;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;
import n2.purpose.TodoTask;

/**
 * Represents the {@code todo} command, which adds a {@link TodoTask}
 * to the {@link TaskList}.
 *
 * <p>When executed, this task is appended to the list and the user receives
 * a confirmation message.</p>
 */
public class TodoCommand extends Command {
    /**
     * The {@link TodoTask} created from user input.
     */
    private TodoTask todoTask;

    /**
     * Creates a new {@code TodoCommand} by parsing the raw user input.
     * <p>
     * Expects input in the format: {@code todo <description>}.
     * </p>
     *
     * @param input raw user input
     * @throws RedGirlsException if the description is missing or empty
     */
    public TodoCommand(String input) throws RedGirlsException {
        handleTodoTaskInput(input);
    }

    /**
     * Parses the user input to extract the description and creates a {@link TodoTask}.
     * <p>
     * Validates that the input contains a non-empty description.
     * </p>
     *
     * @param input raw input string
     * @throws RedGirlsException if the description is missing or empty
     */
    private void handleTodoTaskInput(String input) throws RedGirlsException {
        if(input.length() <= 5) {
            throw RedGirlsException.invalidTodoTask();
        }
        String description = input.substring(5).trim();

        if (description.isEmpty()) {
            throw RedGirlsException.invalidTodoTask();
        }
        todoTask = new TodoTask(description);
    }

    /**
     * Executes the {@code todo} command.
     * <p>
     * Adds the {@link TodoTask} to {@link TaskList} and prints a confirmation message.
     * </p>
     */
    @Override
    public void execute() {
        TaskList.addTask(todoTask);
    }

    /**
     * Indicates that this command does not terminate the program.
     *
     * @return @always {@code false}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
