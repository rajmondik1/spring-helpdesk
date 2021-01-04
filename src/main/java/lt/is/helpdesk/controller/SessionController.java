package lt.is.helpdesk.controller;

import lt.is.helpdesk.dto.ChatSessionDTO;
import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.service.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatSessionService sessionService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Long newSession() {

        ChatSession session = sessionService.save(new ChatSession());

        messagingTemplate.convertAndSendToUser(
                session.getId().toString(),
                "",
                "Pipi");

        return session.getId();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<ChatSessionDTO> list() {
        return sessionService.list();
    }
}
