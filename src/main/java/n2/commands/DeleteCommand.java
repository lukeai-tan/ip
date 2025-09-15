package n2.commands;

import static n2.charisma.Dialogue.redGirlsPrint;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String input) throws RedGirlsException {
        handleDeleteTaskInput(input);
    }

    public void handleDeleteTaskInput(String input) throws RedGirlsException {
        String[] parts = input.split("\\s+");
        if (parts.length < 2) {
            throw RedGirlsException.invalidDelete();
        }
        if (parts.length > 2) {
            throw RedGirlsException.invalidTaskIndex();
        }

        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            redGirlsPrint("Your fragment index... unreadable. Chaos in the pattern.");
            return;
        }

        if (index < 0 || index >= TaskList.getSize()) {
            throw RedGirlsException.invalidTaskIndex();
        }
    }

    @Override
    public void execute() throws RedGirlsException {
        TaskList.deleteTask(index);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
