package lt.is.helpdesk.service;

import lt.is.helpdesk.entity.ChatMessage;
import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.repository.ChatMessageRepository;
import lt.is.helpdesk.repository.ChatSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ChatSessionRepository chatSessionRepository;

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
        ChatSession session = chatMessage.getSession();
        chatSessionRepository.save(session);

        return chatMessage;
    }
}
