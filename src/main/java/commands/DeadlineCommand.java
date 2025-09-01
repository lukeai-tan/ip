package commands;

import intellect.RedGirlsException;
import purpose.TaskList;
import purpose.DeadlineTask;

public class DeadlineCommand extends Command {
    DeadlineTask deadlineTask;

    public DeadlineCommand(String input) throws RedGirlsException {
        handleDeadlineTaskInput(input);
    }

    public void handleDeadlineTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/by", 2);
        String description = parts[0].trim();
        String deadline = (parts.length > 1) ? parts[1].trim() : null;
        if (deadline != null && !deadline.isEmpty()) {
            deadlineTask = new DeadlineTask(description, deadline);
        } else {
            throw RedGirlsException.invalidDeadlineTask();
        }
    }

    @Override
    public void execute() {
        TaskList.addDeadline(deadlineTask);
    }
}
