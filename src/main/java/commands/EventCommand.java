package commands;

import intellect.RedGirlsException;
import purpose.TaskList;
import purpose.EventTask;

public class EventCommand extends Command {
    private EventTask eventTask;

    public EventCommand(String input) throws RedGirlsException {
        handleEventTaskInput(input);
    }

    private void handleEventTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/from", 2);
        String description = parts[0].trim();

        if (parts.length < 2) {
            throw RedGirlsException.invalidEventTask();
        }
        String[] timeParts = parts[1].split("/to", 2);
        String from = timeParts[0].trim();
        String to = (timeParts.length > 1) ? timeParts[1].trim() : null;

        if (to != null && !to.isEmpty()) {
            eventTask = new EventTask(description, from, to);
        } else {
            throw RedGirlsException.missingEventEndTime();
        }
    }

    @Override
    public void execute() {
        TaskList.addEvent(eventTask);
    }
}
