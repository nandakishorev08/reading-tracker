public class Topic {
    private String id;
    private String subject;
    private String title;
    private String description;
    private Status status;

    public Topic(String id, String subject, String title, String description, Status status) {
        this.id = id;
        this.subject = subject;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " (" + subject + ") - " + status;
    }

    // For file storage
    public String toFileString() {
        return id + "|" + subject + "|" + title + "|" + description + "|" + status;
    }

    // Convert from file line to Topic object
    public static Topic fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 5) return null;

        return new Topic(
            parts[0],
            parts[1],
            parts[2],
            parts[3],
            Status.valueOf(parts[4])
        );
    }
}
