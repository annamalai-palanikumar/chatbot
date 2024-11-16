package in.er.annamalai.model;

public class Message {

    private String from;    // Who is sending the message (e.g., Customer or Support)
    private String to;      // To whom the message is intended
    private String content; // Message content

    // Getters and setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
