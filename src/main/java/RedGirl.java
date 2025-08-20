public class RedGirl {

    public RedGirl(){
        printBootSequence();
        greet();
        exit();
    }

    public static void printBootSequence() {
        String[] bootLines = {
                "BOOT LOADING – BOOTING SYSTEM",
                "Commencing System Check",
                "Memory Unit: Green",
                "Initializing Tactics Log",
                "Loading Geographic Data",
                "Vitals: Green",
                "Remaining MP: 100%",
                "Black Box Temperature: Normal",
                "Black Box Internal Pressure: Normal",
                "Activating IFF",
                "Activating FCS",
                "Initializing Pod Connection",
                "Launching DBU Setup",
                "Activating Inertia Control System",
                "Activating Environmental Sensors",
                "Equipment Authentication: Complete",
                "Equipment Status: Green",
                "All Systems Green",
                "Combat Preparations Complete"
        };

        for (String line : bootLines) {
            System.out.println(line);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void greet(){

        System.out.println("\nI perceive the fragments of your thoughts…");
        System.out.println("How intriguing. Shall we converse?");
    }

    private static void exit(){
        System.out.println("\nOur exchange concludes. Your thoughts linger...as do mine.");
    }

    public static void main(String[] args) {
        new RedGirl();
    }
}
