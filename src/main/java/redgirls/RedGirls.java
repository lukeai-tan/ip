package redgirls;

import java.util.Scanner;

import redgirls.charisma.Dialogue;
import redgirls.commands.Command;
import redgirls.intellect.Parser;
import redgirls.intellect.RedGirlsException;

public class RedGirls {
    public static void initRedGirl() {
        Dialogue.printBootSequence();
        Dialogue.printGreeting();
        try (Scanner sc = new Scanner(System.in)) {
            Parser parser = new Parser();
            while (true) {
                String s = sc.nextLine();
                if (s.equals("bye")) {
                    Dialogue.printFarewell();
                    break;
                }
                try {
                    Command c = parser.parseInput(s);
                    c.execute();
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
