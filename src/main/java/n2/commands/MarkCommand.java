package n2.commands;

import static n2.charisma.Dialogue.redGirlsPrint;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

public class MarkCommand extends Command {
    private String command;
    private int index;

    public MarkCommand(String input) throws RedGirlsException {
        handleMarkInput(input);
    }

    public void handleMarkInput(String input) throws RedGirlsException {
        String[] parts = input.split("\\s+");
        if (parts.length != 2) {
            if(parts.length < 2) {
                throw RedGirlsException.invalidMark();
            } else {
                throw RedGirlsException.invalidTaskIndex();
            }
        }

        this.command = parts[0];

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
    public boolean execute() {
        switch (command) {
        case "mark" -> TaskList.markTaskEntry(index);
        case "unmark" -> TaskList.unmarkTaskEntry(index);
        default -> redGirlsPrint("Unknown command. Reality distorts. " +
                "Are you this world's Singularity?");
        }
        return true;
    }
}
