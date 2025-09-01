package commands;

import intellect.RedGirlsException;
import purpose.TaskList;
import purpose.TodoTask;

public class TodoCommand extends Command {
    private TodoTask todoTask;

    public TodoCommand(String input) throws RedGirlsException {
        handleTodoTaskInput(input);
    }

    private void handleTodoTaskInput(String input) throws RedGirlsException {
        String description = input.substring(5).trim();
        if (description.isEmpty()) {
            throw RedGirlsException.invalidTodoTask();
        }
        todoTask = new TodoTask(description);
    }

    @Override
    public void execute() {
        TaskList.addTodo(todoTask);
    }
}
