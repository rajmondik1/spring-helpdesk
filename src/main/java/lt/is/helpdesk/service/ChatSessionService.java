package lt.is.helpdesk.service;

import lt.is.helpdesk.dto.ChatSessionDTO;
import lt.is.helpdesk.entity.ChatMessage;
import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.entity.ChatSessionStatus;
import lt.is.helpdesk.repository.ChatSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatSessionService {

    @Autowired
    private ChatSessionRepository chatSessionRepository;

    public ChatSession save(ChatSession chatSession) {
        chatSessionRepository.save(chatSession);
        return chatSession;
    }



    public ChatSession find(Long id) {
        return chatSessionRepository.findById(id);
    }

    public List<ChatSessionDTO> list() {
        List<ChatSessionDTO> list = new ArrayList<>();

        chatSessionRepository
                .findAll()
                .iterator()
                .forEachRemaining(e -> list.add(new ChatSessionDTO(e.getId())))
        ;

        return list;
    }
}
