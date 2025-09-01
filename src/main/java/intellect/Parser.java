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

    public void parseInput(String input) {
        try {
            String command;
            if (input.contains(" ")) {
                command = input.substring(0, input.indexOf(" "));
            } else {
                command = input;
            }
            switch (command) {
            case "list":
                tasks.printList();
                break;
            case "mark":
            case "unmark":
                tasks.handleMarkInput(input);
                break;
            case "deadline":
                handleDeadlineTaskInput(input);
                break;
            case "event":
                handleEventTaskInput(input);
                break;
            case "todo":
                handleTodoTaskInput(input);
                break;
            default:
                throw RedGirlsException.unknownCommand();
            }
        } catch (RedGirlsException e) {
            System.out.println(e.getMessage());
        }
    }
}
