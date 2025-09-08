package n2.memory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import n2.intellect.RedGirlsException;
import n2.purpose.Task;

public class MemoryArchive {

    public static final String FILE_PATH = "MachineNetwork.txt";

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

    public static ArrayList<Task> load() throws RedGirlsException {
        return null;
    }
}
