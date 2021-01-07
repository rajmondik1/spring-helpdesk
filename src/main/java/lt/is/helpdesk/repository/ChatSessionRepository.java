package lt.is.helpdesk.repository;

import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.entity.ChatSessionStatus;
import org.springframework.data.repository.CrudRepository;
public interface ChatSessionRepository extends CrudRepository<ChatSession, String> {
    ChatSession findById(Long id);
    ChatSessionStatus findByStatus(ChatSessionStatus status);
}
