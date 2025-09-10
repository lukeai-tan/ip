package n2.charisma;

public class Dialogue {
    private static final int BOOT_DELAY_MS = 200;

    public static String toRedGirlsString(String dialogue) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + dialogue + reset;
    }

    public static void redGirlsPrint(String dialogue) {
        System.out.println();
        typingEffectPrint(toRedGirlsString(dialogue), 5);
        System.out.println();
    }

    public static void typingEffectPrint(String s, int duration) {
        for(int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

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
                Thread.sleep(BOOT_DELAY_MS);
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

    public static void printCommandList() {
        String commandList = """
                [Red Girls] System Online.
                I am here to assist... or observe.

                Available commands:

                  • list      : Display all current tasks. I see everything you have accumulated.
                  • todo      : Add a simple task. Even the smallest action matters.
                  • deadline  : Add a task with a due date. Time is relentless; do not waste it.
                  • event     : Schedule an event. Every moment is fleeting.
                  • mark      : Mark a task as complete. Completion... is temporary, yet necessary.
                  • unmark    : Undo a completed task. Mistakes... are expected.
                  • bye       : Terminate this session. I will remember nothing.
                  • help      : Display this list again. Even I grow tired of repetition.

                Use your commands wisely. Nothing lasts forever, not even this list.
                """;
        redGirlsPrint(commandList);
    }

    public static void printDeleteTaskDialogue() {
        redGirlsPrint("Fragment erased. Another voice silenced in the network.");
    }
}
