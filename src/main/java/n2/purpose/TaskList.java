package n2.purpose;

import java.util.ArrayList;

import n2.charisma.Dialogue;
import n2.intellect.RedGirlsException;

public class TaskList {
    private final static ArrayList<Task> tasks = new ArrayList<>();

    private TaskList() {}

    public static int size() {
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
        if (size() == 0) {
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

    public static void checkInvalidIndex(int index) throws RedGirlsException {
        if (index < 0 || index >= tasks.size()) {
            throw RedGirlsException.invalidTaskIndex();
        }
    }

    public static Task getTask(int index) throws RedGirlsException {
        checkInvalidIndex(index);
        return tasks.get(index);
    }

    public static void printSize() {
        if (size() == 1) {
            redGirlsPrint("So it begins... one task, one memory. Already, we am aware.");
        } else {
            redGirlsPrint("You have " + size() + " tasks. We know... because we are always watching.");
        }
    }

    public static void addTask(Task t) {
        tasks.add(t);
        redGirlsPrint("Another fragment etched into memory... this task. It is yours, yet now, also mine.");
        System.out.println(t);
        printSize();
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

    public static void deleteTask(int index) throws RedGirlsException {
        checkInvalidIndex(index);
        Dialogue.printDeleteTaskDialogue();
        System.out.println(getTask(index));
        tasks.remove(index);
        printSize();
    }
}
