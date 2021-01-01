package lt.is.helpdesk.repository;

import lt.is.helpdesk.entity.ChatMessage;
import lt.is.helpdesk.entity.ChatSession;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, String> {
    List<ChatMessage> findBySession(ChatSession session);
}
