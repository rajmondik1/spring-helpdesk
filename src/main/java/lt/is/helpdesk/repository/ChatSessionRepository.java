package lt.is.helpdesk.repository;

import lt.is.helpdesk.entity.ChatSession;
import org.springframework.data.repository.CrudRepository;
public interface ChatSessionRepository extends CrudRepository<ChatSession, String> {
    ChatSession findById(Long id);
}
