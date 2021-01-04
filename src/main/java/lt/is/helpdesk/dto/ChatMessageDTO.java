package lt.is.helpdesk.dto;

public class ChatMessageDTO {

    private String content;
    private String sender;

    public ChatMessageDTO(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

}
