import java.util.Scanner;

import charisma.Dialogue;
import intellect.Parser;

public class RedGirls {
    public static void initRedGirl() {
        Dialogue.printBootSequence();
        Dialogue.printGreeting();
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
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

    public static void main(String[] args) {
        initRedGirl();
    }
}
