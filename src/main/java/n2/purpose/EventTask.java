package n2.purpose;

public class EventTask extends Task {
    protected String from;
    protected String to;

    public EventTask(String description, String from, String to) {
        super(description);
        setFrom(from);
        setTo(to);
    }

    public EventTask(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + " )";
    }

    @Override
    public String serialize() {
        int doneFlag = isDone ? 1 : 0;
        return String.format("E | %d | %s | %s-%s", doneFlag, description, from, to);
    }
}
