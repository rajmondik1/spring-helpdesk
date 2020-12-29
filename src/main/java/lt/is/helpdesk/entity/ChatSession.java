package lt.is.helpdesk.entity;

import javax.persistence.*;
import java.util.List;

public class ChatSession {

    private Long id;

    private String token;

    private List<ChatMessage> messages;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
