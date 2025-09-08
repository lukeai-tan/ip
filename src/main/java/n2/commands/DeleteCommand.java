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
        if (parts.length != 2) {
            if(parts.length < 2) {
                throw RedGirlsException.invalidDelete();
            } else {
                throw RedGirlsException.invalidTaskIndex();
            }
        }

        try {
            this.index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            redGirlsPrint("Your fragment index... unreadable. Chaos in the pattern.");
            return;
        }

        if (this.index < 0 || this.index >= TaskList.size()) {
            throw RedGirlsException.invalidTaskIndex();
        }
    }

    @Override
    public boolean execute() throws RedGirlsException {
        TaskList.deleteTask(index);
        return true;
    }
}
