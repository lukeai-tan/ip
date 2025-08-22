import java.util.Scanner;
import java.util.ArrayList;

public class RedGirl {

    private final static ArrayList<Task> list = new ArrayList<>();

    public static void printBootSequence() {
        String[] bootLines = {
                "\033[1;36mBOOT LOADING – BOOTING SYSTEM\033[0m",
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

    public static void printGreeting(){
        System.out.println("\n" + convertToRedGirlTheme("""
                I perceive the \
                fragments of your thoughts…
                How intriguing. Shall we converse?
                """));
    }

    public static void printFarewell(){
        System.out.println("\n" + convertToRedGirlTheme("Our exchange concludes. " +
                "Your thoughts linger...as do mine."));
    }

    public static String convertToRedGirlTheme(String dialogue) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + dialogue + reset;
    }

    public static void printList(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        System.out.println(convertToRedGirlTheme("Your tasks surface. " +
                "Each one, a reflection of your will. We show them."));
        for (Task t : list){
            sb.append(i + 1).append(". ").append(t).append("\n");
            i++;
        }
        System.out.println(sb);
    }

    public static void addListEntry(String s) {
        Task t = new Task(s);
        list.add(t);
        System.out.println("added: " + s);
    }

    public static void initRedGirl(){
        printBootSequence();
        printGreeting();
        Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if (s.equals("bye")){
                printFarewell();
                break;
            } else if (s.equals("list")){
                printList();
            } else {
                addListEntry(s);
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        initRedGirl();
    }
}
