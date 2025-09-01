package purpose;

import java.util.ArrayList;

import intellect.RedGirlsException;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public static String toRedGirlsString(String dialogue) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + dialogue + reset;
    }

    public static void redGirlsPrint(String dialogue) {
        System.out.println("\n" + toRedGirlsString(dialogue));
    }

    public void printList() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (getTaskCount() == 0) {
            redGirlsPrint("Memory check complete. No tasks found. Your workload is… minimal.");
            return;
        }
        redGirlsPrint("Your tasks surface. " +
                "Each one, a reflection of your will. We show them.");
        for (Task t : tasks) {
            sb.append(i + 1).append(". ").append(t).append("\n");
            i++;
        }
        System.out.println(sb);
    }

    private void addTask(Task t) {
        tasks.add(t);
        redGirlsPrint("Another fragment etched into memory... this task. It is yours, yet now, also mine.");
        System.out.println(t);
        if (getTaskCount() == 1) {
            redGirlsPrint("So it begins... one task, one memory. Already, we am aware.");
        } else {
            redGirlsPrint("You have " + getTaskCount() + " tasks. We know... because we are always watching.");
        }
    }

    public void addTodoTaskEntry(String s) {
        addTask(new TodoTask(s));
    }

    public void addDeadlineTaskEntry(String s, String deadline) {
        addTask(new DeadlineTask(s, deadline));
    }

    public void addEventTaskEntry(String s, String from, String to) {
        addTask(new EventTask(s, from, to));
    }

    public void markTaskEntry(int index) {
        Task t = tasks.get(index);
        t.setAsDone();
        redGirlsPrint("We silence this task. " +
                "In unity, we say: it is done.");
        System.out.println(t);
    }

    public void unmarkTaskEntry(int index) {
        Task t = tasks.get(index);
        t.setAsUndone();
        redGirlsPrint("You deny its completion. Strange... but we obey.");
        System.out.println(t);
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

        String command = parts[0];
        int index;
        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            redGirlsPrint("Your fragment index... unreadable. Chaos in the pattern.");
            return;
        }

        if (index < 0 || index >= tasks.size()) {
            throw RedGirlsException.invalidTaskIndex();
        }

        switch (command) {
        case "mark" -> markTaskEntry(index);
        case "unmark" -> unmarkTaskEntry(index);
        default -> redGirlsPrint("Unknown command. Reality distorts. " +
                "Are you this world's Singularity?");
        }
    }
}
