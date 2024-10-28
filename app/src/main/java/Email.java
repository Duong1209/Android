public class Email {
    private final String senderName;
    private final String subject;
    private final String time;

    public Email(String senderName, String subject, String time) {
        this.senderName = senderName;
        this.subject = subject;
        this.time = time;
    }

    public String getSenderName() { return senderName; }
    public String getSubject() { return subject; }
    public String getTime() { return time; }

    public String getInitial() {
        return senderName.substring(0, 1); // Get the first letter as the initial
    }
}
