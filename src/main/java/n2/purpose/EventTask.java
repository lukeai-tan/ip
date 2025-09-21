package n2.purpose;

/**
 * Represents an event {@link Task} with a start and end time. <br>
 * An {@code EventTask} extends the basic task class by including
 * a {@code from} time and a {@code to} time to specify when the event occurs.
 *
 * <p>It is serialized with the prefix {@code "E} to distinguish it from
 * other task types.</p>
 */
public class EventTask extends Task {
    /**
     * Starting time or point of the event.
     */
    protected String from;

    /**
     * Ending time or point of the event.
     */
    protected String to;

    /**
     * Creates a new {@code EventTask} with the given description,
     * start and end time. <br>
     * By default, the task is marked as not done.
     *
     * @param description description of the event
     * @param from the starting time or point
     * @param to the ending time or point
     */
    public EventTask(String description, String from, String to) {
        super(description);
        setFrom(from);
        setTo(to);
    }

    /**
     * Creates a new {@code EventTask} with the given description,
     * start and end time, and initial completion state.
     *
     * @param description description of the event
     * @param from the starting time or point
     * @param to the ending time or point
     * @param isDone whether the task is marked as completed
     */
    public EventTask(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * Updates the start time of the event.\
     *
     * @param from the new start time or point
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Updates the end time of the event.
     *
     * @param to the new end time or point
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Returns a string representation of this event task,
     * including its type, status, description and time period. <br>
     * E.g. {@code [E][ ] CS2113 exam (from: 9am to: 10.15am)}
     *
     * @return formatted string for display
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Serializes this event task into a compact string format suitable for storage.
     * Format: {@code E | <done-flag> | <description> | <from>-<to>} <br>
     * where {@code <done-flag} is {@code 1} if done and {@code 0} if not.
     *
     * @return serialized string representation of the event task
     */
    @Override
    public String serialize() {
        int doneFlag = isDone ? 1 : 0;
        return String.format("E | %d | %s | %s-%s", doneFlag, description, from, to);
    }
}
