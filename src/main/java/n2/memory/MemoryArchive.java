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

public class MemoryArchive {

    public static final String FILE_PATH = "./src/main/java/data/MachineNetwork.txt";

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

    public static Task deserialize(String line) throws RedGirlsException {
        try {
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
                throw RedGirlsException.unknownTaskType();
            }
        } catch (Exception e) {
            throw RedGirlsException.corruptedSave();
        }
    }

    public static ArrayList<Task> load() throws RedGirlsException {
        ArrayList<Task> savedTasks = new ArrayList<>();
        File savefile = new File(FILE_PATH);
        if (!savefile.exists()) {
            return savedTasks;
        }
        try (Scanner sc = new Scanner(savefile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Task task = deserialize(line);
                savedTasks.add(task);
            }
        } catch (FileNotFoundException e) {
            throw RedGirlsException.corruptedSave();
        }
        return savedTasks;
    }
}
