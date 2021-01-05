package lt.is.helpdesk.dto;

import java.util.Date;

public class ChatMessageDTO {

    private String content;
    private String sender;
    private Date date;

    public ChatMessageDTO(String content, String sender, Date date) {
        this.content = content;
        this.sender = sender;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public Date getDate() {
        return date;
    }

}
