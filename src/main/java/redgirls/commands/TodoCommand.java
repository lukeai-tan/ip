package redgirls.commands;

import redgirls.intellect.RedGirlsException;
import redgirls.purpose.TaskList;
import redgirls.purpose.TodoTask;

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
    public boolean execute() {
        TaskList.addTodo(todoTask);
        return true;
    }
}
