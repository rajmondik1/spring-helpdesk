package lt.is.helpdesk.repository;

import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.entity.ChatSessionStatus;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ChatSessionRepository extends CrudRepository<ChatSession, String> {
    ChatSession findById(Long id);
    List<ChatSession> findByStatus(ChatSessionStatus status);
}
