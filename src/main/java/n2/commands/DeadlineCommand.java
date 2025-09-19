package n2.commands;

import n2.intellect.DateConverter;
import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;
import n2.purpose.DeadlineTask;

public class DeadlineCommand extends Command {
    private DeadlineTask deadlineTask;

    public DeadlineCommand(String input) throws RedGirlsException {
        handleDeadlineTaskInput(input);
    }

    private void handleDeadlineTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/by", 2);
        String description = parts[0].trim();
        String deadline = (parts.length > 1) ? parts[1].trim() : null;

        Object parsedDeadline = DateConverter.parseDateTime(deadline);
        deadline = DateConverter.formatDateTime(parsedDeadline);

        if (deadline != null && !deadline.isEmpty()) {
            deadlineTask = new DeadlineTask(description, deadline);
        } else {
            throw RedGirlsException.invalidDeadlineTask();
        }
    }

    @Override
    public void execute() throws RedGirlsException {
        TaskList.addTask(deadlineTask);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
