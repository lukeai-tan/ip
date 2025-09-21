package n2.purpose;

/**
 * Represents a basic todo task. <br>
 * A {@code TodoTask} is the simplest type of {@link Task},
 * defined only be a description and its state of completion.
 *
 * <p>It is serialized with the prefix {@code "T"} to distinguish it
 * from other task types.</p>
 */
public class TodoTask extends Task {
    /**
     * Creates a new {@code TodoTask} with the given description.
     * By default, the task is marked as not done.
     *
     * @param description description of the task
     */
    public TodoTask(String description) {
        super(description);
    }

    /**
     * Creates a new {@code TodoTask} with the given description and state of completion.
     * @param description description of the task
     * @param isDone whether the task is marked as completed
     */
    public TodoTask(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns a string representation of the task, prefixed with {@code [T]}.
     *
     * @return formatted string for display
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Serializes the task into a compact string format suitable for storaghe. <br>
     * Format: {@code T | <done-flag> | <description>} <br>
     * where {@code <done-flag>} is {@code 1} if done and {@code 0} if not.
     *
     * @return serialized string representation of this todo task
     */
    @Override
    public String serialize() {
        return String.format("T | %d | %s", isDone ? 1 : 0, description);
    }
}
