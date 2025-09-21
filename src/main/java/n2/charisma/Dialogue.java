package n2.charisma;

/**
 * The Dialogue class provides text output seen by the user for the Red Girls interface.
 * <p>
 * It encapsulates the theme of the Red Girls from NieR:Automata through
 * dark red text colors, stylized messages and their inspired personality in the dialogue.
 * </p>
 * <p>
 * It also provides presentation effects such as boot sequences similar to the loading sequence
 * of the actual game, as well as delayed typing to create a sense of immersion.
 * </p>
 */
public class Dialogue {
    /**
     * Delay specifically for printing the boot sequence
     */
    private static final int BOOT_DELAY_MS = 200;

    /**
     * Delay specifically for creating an illusion of a typing effect
     */
    private static final int TYPING_DELAY_MS = 5;

    /**
     * Applies Red Girls' dark red ANSI color to a string.
     *
     * @param dialogue original dialogue string
     * @return dark red colored string
     */
    public static String toRedGirlsString(String dialogue) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + dialogue + reset;
    }

    /**
     * Prints a line of dialogue in Red Girls' style with a typing effect.
     * <p>
     * Inserts blank lines before and after each dialogue for spacing.
     * </p>
     *
     * @param dialogue the dialogue to display
     */
    public static void redGirlsPrint(String dialogue) {
        System.out.println();
        typingEffectPrint(toRedGirlsString(dialogue), TYPING_DELAY_MS);
        System.out.println();
    }

    /**
     * Prints a string character by character with a delay between each,
     * creating an illusion of a "typing" effect.
     *
     * @param s string to display with typing effect
     * @param duration delay in milliseconds per character
     */
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

    /**
     * Simulates a boot-up diagnostic sequence line by line, with pauses between
     * each line to mimic system initialization.
     * <p>Inspired and taken from NieR:Automata's boot sequence.</p>
     */
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

    /**
     * Prints the Red Girls' greeting when the program starts.
     */
    public static void printGreeting() {
        redGirlsPrint("I perceive the fragments of your thoughts…\n" +
                "How intriguing. Shall we converse?");
    }

    /**
     * Prints the Red Girls' farewell before the program is terminated.
     */
    public static void printFarewell() {
        redGirlsPrint("Our exchange concludes. Your thoughts linger...as do mine.");
    }

    /**
     * Displays the help menu with a list of supported commands,
     * detailed by the Red Girls' with their personalized narration.
     */
    public static void printCommandList() {
        String commandList = """
                [Red Girls] System Online.
                I am here to assist... or observe.

                Available commands:

                  ? list      : Display all current tasks. I see everything you have accumulated.
                  ? todo      : Add a simple task. Even the smallest action matters.
                  ? deadline  : Add a task with a due date. Time is relentless; do not waste it.
                  ? event     : Schedule an event. Every moment is fleeting.
                  ? mark      : Mark a task as complete. Completion... is temporary, yet necessary.
                  ? unmark    : Undo a completed task. Mistakes... are expected.
                  ? delete    : Remove a task entirely. Erasure... a fate more final than death.
                  ? bye       : Terminate this session. I will remember nothing.
                  ? help      : Display this list again. Even I grow tired of repetition.

                Use your commands wisely. Nothing lasts forever, not even this list.
                """;
        redGirlsPrint(commandList);
    }

    /**
     * Prints the Red Girls' response when a task is deleted.
     */
    public static void printDeleteTaskDialogue() {
        redGirlsPrint("Fragment erased. Another voice silenced in the network.");
    }
}
