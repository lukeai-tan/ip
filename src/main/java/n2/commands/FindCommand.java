package n2.commands;

import n2.intellect.RedGirlsException;
import n2.purpose.TaskList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String input) throws RedGirlsException {
        handleFindKeywordParsing(input);
    }

    public void handleFindKeywordParsing(String input) throws RedGirlsException {
        String[] parts = input.split("\\s+", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw RedGirlsException.invalidKeyword();
        }
        keyword = parts[1].trim();
    }

    @Override
    public void execute() {
        TaskList.printFilteredList(keyword);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
