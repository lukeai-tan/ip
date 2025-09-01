package intellect;

import purpose.TaskList;

public class Parser {
    public TaskList tasks;

    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    public void handleTodoTaskInput(String input) throws RedGirlsException {
        String description = input.substring(5).trim();
        if (description.isEmpty()) {
            throw RedGirlsException.invalidTodoTask();
        }
        tasks.addTodoTaskEntry(description);
    }

    public void handleDeadlineTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/by", 2);
        String description = parts[0].trim();
        String deadline = (parts.length > 1) ? parts[1].trim() : null;
        if (deadline != null && !deadline.isEmpty()) {
            tasks.addDeadlineTaskEntry(description, deadline);
        } else {
            throw RedGirlsException.invalidDeadlineTask();
        }
    }

    public void handleEventTaskInput(String input) throws RedGirlsException {
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
            tasks.addEventTaskEntry(description, from, to);
        } else {
            throw RedGirlsException.missingEventEndTime();
        }
    }

    public void parseInput(String input) throws RedGirlsException {
        if (input.equals("list")) {
            tasks.printList();
        } else if (input.startsWith("mark ") || input.startsWith("unmark ")) {
            tasks.handleMarkInput(input);
        } else if (input.startsWith("deadline ")) {
            handleDeadlineTaskInput(input);
        } else if (input.startsWith("event ")) {
            handleEventTaskInput(input);
        } else if (input.startsWith("todo ")) {
            handleTodoTaskInput(input);
        } else {
            throw RedGirlsException.unknownCommand();
        }
    }
}
