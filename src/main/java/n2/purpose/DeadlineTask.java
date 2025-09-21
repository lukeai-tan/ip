package n2.purpose;

/**
 * Represents a deadline {@link Task} with a specific due date or time. <br>
 * A {@code DeadlineTask} extends the task class by including
 * a {@code deadline} field that indicates when the task must be completed.
 *
 * <p>It is serialized with the prefix {@code "D"} to distinguish it
 * from other task types.</p>
 */
public class DeadlineTask extends Task {
    /**
     * The due date or time for the deadline task.
     */
    protected String deadline;

    /**
     * Creates a new {@code DeadlineTask} with the given description and deadline. <br>
     * By default, the task is marked as not done.
     *
     * @param description description of the task
     * @param deadline the due date or time
     */
    public DeadlineTask(String description, String deadline) {
        super(description);
        setDeadline(deadline);
    }

    /**
     * Creates a new {@code DeadlineTask} with the given description, deadline
     * and initial completion state.
     *
     * @param description description of the task
     * @param deadline due date or time
     * @param isDone whether the task is marked as done
     */
    public DeadlineTask(String description, String deadline, boolean isDone) {
        super(description, isDone);
        this.deadline = deadline;
    }

    /**
     * Returns the deadline of this task.
     *
     * @return the deadline string
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * Updates the deadline of this task.
     *
     * @param deadline the new deadline string
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * Returns a string representation of this deadline task,
     * including its type, status, description, and deadline. <br>
     *
     * @return formatted string for display
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDeadline() + ")";
    }

    /**
     * Serializes this deadline task into a compact string format suitable for storage. <br>
     * Format: {@code D | <done-flag> | <description> | <deadline>} <br>
     * where {@code <done-flag>} is {@code 1} if done and {@code 0} if not.
     *
     * @return serialized string representation of the deadline task
     */
    @Override
    public String serialize() {
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, description, deadline);
    }
}
