package lt.is.helpdesk.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table()
public class ChatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private ChatSessionStatus status;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<ChatMessage> messages = new ArrayList<ChatMessage>();

    public ChatSession() { }

    public ChatSession(String id) {
        this.id = Long.getLong(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void addMessage(ChatMessage message) {
        this.messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) { this.messages = messages; }

    public ChatSessionStatus getStatus() { return status; }

    public void setStatus(ChatSessionStatus status) { this.status = status; }
}
