public class RedGirlsException extends Exception {
    public RedGirlsException(String s) {
        super(toRedGirlsString(s));
    }

    public static String toRedGirlsString(String s) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + s + reset;
    }

    public static RedGirlsException invalidTaskIndex() {
        return new RedGirlsException("Your fragment index... unreadable. Chaos in the pattern.");
    }

    public static RedGirlsException invalidTodoTask() {
        return new RedGirlsException("Incomplete command. A todo fragment without form.");
    }

    public static RedGirlsException invalidDeadlineTask() {
        return new RedGirlsException("Incomplete command. A deadline fragment without form.");
    }

    public static RedGirlsException invalidEventTask() {
        return new RedGirlsException("Incomplete command. An event fragment without form.");
    }

    public static RedGirlsException unknownCommand() {
        return new RedGirlsException("Unknown command. Reality distorts. " +
                "Are you this world's Singularity?");
    }
}
