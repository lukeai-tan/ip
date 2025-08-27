public class DeadlineTask extends Task {
    protected String deadline;

    public DeadlineTask(String description, String deadline) {
        super(description);
        setDeadline(deadline);
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}
