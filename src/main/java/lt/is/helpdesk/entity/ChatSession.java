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

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<ChatMessage> messages = new ArrayList<ChatMessage>();

    // TODO: Implement chat session status

    public ChatSession() {
    }

    public ChatSession(String id) {
        this.id = Long.getLong(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
