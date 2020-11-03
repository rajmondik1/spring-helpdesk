package lt.is.helpdesk.model;

public class ChatMessage {
    private MessageType type;
    private String Content;
    private String sender;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
