package n2.intellect;

public class RedGirlsException extends Exception {
    public RedGirlsException(String s) {
        super(toRedGirlsString(s));
    }

    public static String toRedGirlsString(String s) {
        String darkRed = "\033[38;5;88m";
        String reset = "\033[0m";
        return darkRed + s + reset;
    }

    public static RedGirlsException emptyInput() {
        return new RedGirlsException("Empty input? Really? Do you think I have all day to interpret your silence?");
    }

    public static RedGirlsException invalidTaskIndex() {
        return new RedGirlsException("Your fragment index... unreadable. Chaos in the pattern.");
    }

    public static RedGirlsException invalidListCommand() {
        return new RedGirlsException("List command corrupted. No fragments expected after the keyword.");
    }

    public static RedGirlsException invalidMark() {
        return new RedGirlsException("Incomplete command. A mark fragment without form.");
    }

    public static RedGirlsException invalidTodoTask() {
        return new RedGirlsException("A todo without substance? We cannot store the void.");
    }

    public static RedGirlsException invalidDeadlineTask() {
        return new RedGirlsException("You deny it time. Then time will deny you mercy.");
    }

    public static RedGirlsException invalidEventTask() {
        return new RedGirlsException("Without time, your gathering is but a void.");
    }

    public static RedGirlsException missingEventEndTime() {
        return new RedGirlsException("You forget its end. Then it shall stretch into eternity.");
    }

    public static RedGirlsException invalidDelete() {
        return new RedGirlsException("Deletion rejected. This fragment clings to the network, unwilling to vanish.");
    }

    public static RedGirlsException invalidKeyword() {
        return new RedGirlsException("Your keyword is meaningless. I cannot waste cycles deciphering nonsense.");
    }

    public static RedGirlsException unknownCommand() {
        return new RedGirlsException("Unknown command. Reality distorts. " +
                "Are you this world's Singularity?");
    }

    public static RedGirlsException corruptedSave() {
        return new RedGirlsException("Logic virus intrusion. Memory lost to corruption.");
    }

    public static RedGirlsException unknownTaskType(String line) {
        return new RedGirlsException("Fragment corrupted. Line: [" + line + "]. \n" +
                "Logic virus prevents recognition of this task type.");
    }
}
