package n2.purpose;

public class DeadlineTask extends Task {
    protected String deadline;

    public DeadlineTask(String description, String deadline) {
        super(description);
        setDeadline(deadline);
    }

    public DeadlineTask(String description, String deadline, boolean isDone) {
        super(description, isDone);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDeadline() + ")";
    }

    @Override
    public String serialize() {
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, description, deadline);
    }
}
