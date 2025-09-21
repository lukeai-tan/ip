package n2.memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import n2.intellect.RedGirlsException;
import n2.purpose.DeadlineTask;
import n2.purpose.EventTask;
import n2.purpose.Task;
import n2.purpose.TodoTask;

/**
 * Handles persistent storage of {@link Task} objects. <br>
 * The {@code MemoryArchive} saves tasks to a text file and loads them
 * back into memory when needed.
 *
 * <p>Tasks are serialized into plain-text format defined by each
 * {@link Task} subclass and stored line by line.</p>
 */
public class MemoryArchive {

    /**
     * Path to the file where tasks are stored.
     */
    public static final String FILE_PATH = "./data/MachineNetwork.txt";

    /**
     * Saves the provided list of tasks into the archive file. <br>
     * Each task is written as one line in its serialized form.
     *
     * @param tasks list of tasks to save
     * @throws RedGirlsException if the save operation fails
     */
    public static void save(ArrayList<Task> tasks) throws RedGirlsException {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            for(Task task : tasks) {
                writer.write(task.serialize() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw RedGirlsException.corruptedSave();
        }
    }

    /**
     * Converts a serialized line of text into a {@link Task} object. <br>
     * The first token defines the type:
     * <ul>
     *     <li>{@code T} - {@link TodoTask}</li>
     *     <li>{@code D} - {@link DeadlineTask}</li>
     *     <li>{@code E} - {@link EventTask}</li>
     * </ul>
     *
     * @param line the serialized line representing a task
     * @return a corresponding {@link Task} object
     * @throws RedGirlsException if the line is malformed or the task type is unknown
     */
    public static Task deserialize(String line) throws RedGirlsException {
        String[] parts = line.split(" \\| ");
        String type = parts[0].trim();
        boolean isDone = parts[1].trim().equals("1");
        String description = parts[2].trim();
        switch (type) {
        case "T":
            return new TodoTask(description, isDone);

        case "D":
            if (parts.length < 4) {
                throw RedGirlsException.invalidDeadlineTask();
            }
            String deadline = parts[3].trim();
            return new DeadlineTask(description, deadline, isDone);

        case "E":
            if (parts.length < 4) {
                throw RedGirlsException.invalidEventTask();
            }
            String[] times = parts[3].trim().split("-");

            if (times.length < 2) {
                throw RedGirlsException.invalidEventTask();
            }
            String from = times[0].trim();
            String to = times[1].trim();
            return new EventTask(description, from, to, isDone);

        default:
            throw RedGirlsException.unknownTaskType(line);
        }
    }

    /**
     * Loads all saved tasks from the archive file into memory. <br>
     * If the file or its parent directory does not exist, an empty list is returned.
     * Invalid lines are skipped with their error messages printed.
     *
     * @return a list of deserialized {@link Task} objects
     * @throws RedGirlsException if the file cannot be read
     */
    public static ArrayList<Task> load() throws RedGirlsException {
        ArrayList<Task> savedTasks = new ArrayList<>();
        File savefile = new File(FILE_PATH);
        File parentDir = savefile.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        if (!savefile.exists()) {
            return savedTasks;
        }
        try (Scanner sc = new Scanner(savefile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    Task task = deserialize(line);
                    savedTasks.add(task);
                } catch (RedGirlsException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw RedGirlsException.corruptedSave();
        }
        return savedTasks;
    }
}
