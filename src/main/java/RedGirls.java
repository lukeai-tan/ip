import java.util.Scanner;

import charisma.Dialogue;
import intellect.Parser;
import intellect.RedGirlsException;
import purpose.TaskList;

public class RedGirls {
    private final static TaskList tasks = new TaskList();

    public static void initRedGirl() throws RedGirlsException {
        Dialogue.printBootSequence();
        Dialogue.printGreeting();
        Scanner sc = new Scanner(System.in);
        TaskList tasks = new TaskList();
        Parser parser = new Parser(tasks);
        while (true) {
            String s = sc.nextLine();
            if (s.equals("bye")) {
                Dialogue.printFarewell();
                break;
            } else {
                parser.parseInput(s);
            }
        }
        sc.close();
    }

    public static void main(String[] args) throws RedGirlsException {
        initRedGirl();
    }
}
