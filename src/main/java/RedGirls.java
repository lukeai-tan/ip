import java.util.Scanner;
import java.util.ArrayList;

import intellect.RedGirlsException;
import purpose.DeadlineTask;
import purpose.EventTask;
import purpose.Task;
import purpose.TaskList;
import purpose.TodoTask;

public class RedGirls {

    private final static TaskList tasks = new TaskList();

    public static void printBootSequence() {
        String[] bootLines = {
                "\033[1;36mBOOT LOADING - BOOTING SYSTEM\033[0m",
                "Commencing System Check",
                "Memory Unit: \033[32mGreen\033[0m",
                "Initializing Tactics Log",
                "Loading Geographic Data",
                "Vitals: \033[32mGreen\033[0m",
                "Remaining MP: \033[32m100%\033[0m",
                "Black Box Temperature: \033[32mNormal\033[0m",
                "Black Box Internal Pressure: \033[32mNormal\033[0m",
                "Activating IFF",
                "Activating FCS",
                "Initializing Pod Connection",
                "Launching DBU Setup",
                "Activating Inertia Control System",
                "Activating Environmental Sensors",
                "Equipment Authentication: \033[32mComplete\033[0m",
                "Equipment Status: \033[32mGreen\033[0m",
                "\033[1;32mAll Systems Green\033[0m",
                "\033[1;32mCombat Preparations Complete\033[0m"
        };

        for (String line : bootLines) {
            System.out.println(line);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void printGreeting() {
        redGirlsPrint("I perceive the fragments of your thoughts…\n" +
                "How intriguing. Shall we converse?");
    }

    public static void printFarewell() {
        redGirlsPrint("Our exchange concludes. Your thoughts linger...as do mine.");
    }

    public static String toRedGirlsString(String dialogue) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + dialogue + reset;
    }

    public static void redGirlsPrint(String dialogue) {
        System.out.println("\n" + toRedGirlsString(dialogue));
    }

    public static void handleTodoTaskInput(String input) throws RedGirlsException {
        String description = input.substring(5).trim();
        if (description.isEmpty()) {
            throw RedGirlsException.invalidTodoTask();
        }
        tasks.addTodoTaskEntry(description);
    }

    public static void handleDeadlineTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/by", 2);
        String description = parts[0].trim();
        String deadline = (parts.length > 1) ? parts[1].trim() : null;
        if (deadline != null && !deadline.isEmpty()) {
            tasks.addDeadlineTaskEntry(description, deadline);
        } else {
            throw RedGirlsException.invalidDeadlineTask();
        }
    }

    public static void handleEventTaskInput(String input) throws RedGirlsException {
        String[] parts = input
                .substring(input.indexOf(" ") + 1)
                .split("/from", 2);
        String description = parts[0].trim();

        if (parts.length < 2) {
            throw RedGirlsException.invalidEventTask();
        }
        String[] timeParts = parts[1].split("/to", 2);
        String from = timeParts[0].trim();
        String to = (timeParts.length > 1) ? timeParts[1].trim() : null;
        
        if (to != null && !to.isEmpty()) {
            tasks.addEventTaskEntry(description, from, to);
        } else {
            throw RedGirlsException.missingEventEndTime();
        }
    }

    public static void parseInput(String input) throws RedGirlsException {
        if (input.equals("list")) {
            tasks.printList();
        } else if (input.startsWith("mark ") || input.startsWith("unmark ")) {
            tasks.handleMarkInput(input);
        } else if (input.startsWith("deadline ")) {
            handleDeadlineTaskInput(input);
        } else if (input.startsWith("event ")) {
            handleEventTaskInput(input);
        } else if (input.startsWith("todo ")) {
            handleTodoTaskInput(input);
        } else {
            throw RedGirlsException.unknownCommand();
        }
    }

    public static void initRedGirl() throws RedGirlsException {
        printBootSequence();
        printGreeting();
        Scanner sc = new Scanner(System.in);
        TaskList tasks = new TaskList();
        while (true) {
            String s = sc.nextLine();
            if (s.equals("bye")) {
                printFarewell();
                break;
            } else {
                parseInput(s);
            }
        }
        sc.close();
    }

    public static void main(String[] args) throws RedGirlsException {
        initRedGirl();
    }
}
