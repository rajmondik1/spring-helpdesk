package lt.is.helpdesk.dto;

public class ChatMessageDTO {

    private String content;
    private String sender;
    private Long session;

    public ChatMessageDTO(String content, String sender, Long session) {
        this.content = content;
        this.sender = sender;
        this.session = session;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public Long getSession() {
        return session;
    }
}
