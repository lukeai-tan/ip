package n2.purpose;

import static n2.charisma.Dialogue.redGirlsPrint;

import java.util.ArrayList;
import java.util.stream.Collectors;

import n2.charisma.Dialogue;
import n2.intellect.RedGirlsException;
import n2.memory.MemoryArchive;

/**
 * Manages a list of {@link Task} objects.
 * <p>
 * The task list loads its task data from the {@link MemoryArchive} at class initialization
 * and provides operations for adding, deleting, updating, retrieving and printing tasks.
 * </p>
 *
 * <p>This class is static-only and cannot be instantiated.</p>
 */
public class TaskList {
    private final static ArrayList<Task> tasks;

    private TaskList() {}

    static {
        try {
            tasks = MemoryArchive.load();
        } catch (RedGirlsException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the current number of tasks in the list
     *
     * @return total number of tasks
     */
    public static int getSize() {
        return tasks.size();
    }

    /**
     * Returns the underlying task list
     *
     * @return reference to the list of tasks
     */
    public static ArrayList<Task> getTaskList() {
        return tasks;
    }

    /**
     * Prints the complete task list to standard output.
     * <p>
     * If there are no tasks, a special message indicating an empty workload is displayed.
     * </p>
     */
    public static void printList() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (getSize() == 0) {
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

    /**
     * Validates that the given index refers to a valid task in the task list
     *
     * @param index position in the task list
     * @throws RedGirlsException if the index is out of range
     */
    public static void checkInvalidIndex(int index) throws RedGirlsException {
        if (index < 0 || index >= tasks.size()) {
            throw RedGirlsException.invalidTaskIndex();
        }
    }

    /**
     * Retrieves the task at the specified index
     *
     * @param index position of the task (0-indexing)
     * @return the {@link Task} at the specified index
     * @throws RedGirlsException if the index is invalid
     */
    public static Task getTask(int index) throws RedGirlsException {
        checkInvalidIndex(index);
        return tasks.get(index);
    }

    /**
     * Prints the current size of the task list.
     *
     * <p>
     * Dedicated messages are displayed for cases when the task list only contains
     * one task or multiple tasks.
     * </p>
     */
    public static void printSize() {
        if (getSize() == 1) {
            redGirlsPrint("So it begins... one task, one memory. Already, we are aware.");
        } else {
            redGirlsPrint("You have " + getSize() + " tasks. We know... because we are always watching.");
        }
    }

    /**
     * Adds a new task to the list, prints a confirmation message,
     * and displays the updated task list size.
     *
     * @param t the task to be added
     */
    public static void addTask(Task t) {
        tasks.add(t);
        redGirlsPrint("Another fragment etched into memory... this task. It is yours, yet now, also mine.");
        System.out.println(t);
        printSize();
    }

    /**
     * Marks the task at the given index as done
     *
     * @param index position of the task to mark (0-indexing)
     */
    public static void markTaskEntry(int index) {
        Task t = tasks.get(index);
        t.setAsDone();
        redGirlsPrint("We silence this task. " +
                "In unity, we say: it is done.");
        System.out.println(t);
    }

    /**
     * Marks the task at the given index as not done
     *
     * @param index position of the task to unmark (0-indexing)
     */
    public static void unmarkTaskEntry(int index) {
        Task t = tasks.get(index);
        t.setAsUndone();
        redGirlsPrint("You deny its completion. Strange... but we obey.");
        System.out.println(t);
    }

    /**
     * Deletes the task at the specified index from the task list,
     * printing a confirmation message and the updated size.
     *
     * @param index position of the task to delete (0-indexing)
     * @throws RedGirlsException if the index is invalid
     */
    public static void deleteTask(int index) throws RedGirlsException {
        checkInvalidIndex(index);
        Dialogue.printDeleteTaskDialogue();
        System.out.println(getTask(index));
        tasks.remove(index);
        printSize();
    }

    /**
     * Prints all tasks containing the given keyword in their description.
     *
     * <p>
     * The search is case-insensitive.
     * </p>
     *
     * @param keyword string to filter tasks by
     */
    public static void printFilteredList(String keyword) {
        ArrayList<Task> filteredList = tasks.stream()
                .filter(t -> t.description.contains(keyword.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.isEmpty()) {
            redGirlsPrint("No fragments matching \"" + keyword + "\" were found. Silence echoes.");
            return;
        }
        redGirlsPrint("Fragments containing \"" + keyword + "\" reveal themselves. Observe carefully:");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filteredList.size(); i++) {
            sb.append(i + 1).append(". ").append(filteredList.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}

