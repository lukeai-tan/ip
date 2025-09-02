package redgirls.purpose;

import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> tasks = new ArrayList<>();

    private TaskList() {}

    public static int getTaskCount() {
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

    public static void printList() {
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

    private static void addTask(Task t) {
        tasks.add(t);
        redGirlsPrint("Another fragment etched into memory... this task. It is yours, yet now, also mine.");
        System.out.println(t);
        if (getTaskCount() == 1) {
            redGirlsPrint("So it begins... one task, one memory. Already, we am aware.");
        } else {
            redGirlsPrint("You have " + getTaskCount() + " tasks. We know... because we are always watching.");
        }
    }

    public static void addTodo(TodoTask task) {
        addTask(task);
    }

    public static void addDeadline(DeadlineTask task) {
        addTask(task);
    }

    public static void addEvent(EventTask task) {
        addTask(task);
    }

    public static void markTaskEntry(int index) {
        Task t = tasks.get(index);
        t.setAsDone();
        redGirlsPrint("We silence this task. " +
                "In unity, we say: it is done.");
        System.out.println(t);
    }

    public static void unmarkTaskEntry(int index) {
        Task t = tasks.get(index);
        t.setAsUndone();
        redGirlsPrint("You deny its completion. Strange... but we obey.");
        System.out.println(t);
    }
}
