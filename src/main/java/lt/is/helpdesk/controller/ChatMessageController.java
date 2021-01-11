package lt.is.helpdesk.controller;

import lt.is.helpdesk.dto.ChatMessageDTO;
import lt.is.helpdesk.entity.ChatMessage;
import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.service.ChatMessageService;
import lt.is.helpdesk.service.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/chat")

public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private ChatSessionService chatSessionService;

    @RequestMapping(value = "/list/{sessionId}", method = RequestMethod.GET)
    public @ResponseBody List<ChatMessageDTO> list(@PathVariable String sessionId) {

        ChatSession session = chatSessionService.find(Long.parseLong(sessionId));

        if (session != null) {
            return chatMessageService.listAllForSession(session);
        }
        return null;
    }
}
