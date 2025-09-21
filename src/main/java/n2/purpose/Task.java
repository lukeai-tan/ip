package n2.purpose;

/**
 * Represents an abstract task with a description and state of completion. <br>
 * Subclasses (e.g. {@link TodoTask}, {@link EventTask}) define specific task types
 * and have their own serialization formats.
 *
 * <p>Each task has:
 * <ul>
 *     <li>a textual description</li>
 *     <li>a boolean flag indicating whether it is completed</li>
 * </ul>
 * </p>
 */
public abstract class Task {
    /**
     * Textual description of the task
     */
    protected String description;

    /**
     * Whether the task is marked as completed.
     */
    protected boolean isDone;

    /**
     * Creates a new {@code Task} with the given description. <br>
     * The task is initially marked as not done.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Creates a new {@code Task} with the given description and state of completion.
     *
     * @param description description of the task
     * @param isDone whether the task is initially marked as done
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns a status icon representing the task's completion state.
     * <ul>
     *     <li>{@code "X"} if the task is done</li>
     *     <li>{@code " "} (space) if the task is not done</li>
     * </ul>
     * @return the status icon
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks this task as done.
     */
    public void setAsDone() {
        isDone = true;
    }

    /**
     * Marks this task as not done.
     */
    public void setAsUndone() {
        isDone = false;
    }

    /**
     * Returns a formatted string representation of this task
     * including its status icon and description. <br>
     * E.g. {@code [X] Study for CS2113}
     *
     * @return human-readable string representation of the task
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Serializes this task into a compact string format suitable for storage. <br>
     * Each subclass defines its own serialization format.
     * e.g. {@link TodoTask#serialize()}
     *
     * @return serialized string representation of the task
     */
    public abstract String serialize();
}
