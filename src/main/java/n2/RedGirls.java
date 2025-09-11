package n2;

import java.util.Scanner;

import n2.charisma.Dialogue;
import n2.commands.Command;
import n2.intellect.Parser;
import n2.intellect.RedGirlsException;
import n2.memory.MemoryArchive;
import n2.purpose.TaskList;

public class RedGirls {
    public static void initRedGirl() {
        Dialogue.printBootSequence();
        Dialogue.printGreeting();
        try (Scanner sc = new Scanner(System.in)) {
            Parser parser = new Parser();
            while (true) {
                String s = sc.nextLine();
                try {
                    Command c = parser.parseInput(s);
                    if (!c.execute()) {
                        break;
                    }
                    MemoryArchive.save(TaskList.getTaskList());
                } catch (RedGirlsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        initRedGirl();
    }
}
