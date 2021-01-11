package lt.is.helpdesk.controller;

import lt.is.helpdesk.dto.ChatSessionDTO;
import lt.is.helpdesk.entity.ChatSession;
import lt.is.helpdesk.service.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/session")
public class SessionController {

//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatSessionService sessionService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Long newSession() {
        ChatSession session = sessionService.save(new ChatSession());

// TODO: Send message about joined agent
//        messagingTemplate.convertAndSendToUser(
//                session.getId().toString(),
//                "",
//                "");

        return session.getId();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<ChatSessionDTO> list() {
        return sessionService.list();
    }

    @RequestMapping(value = "/close/{sessionId}", method = RequestMethod.PATCH)
    public @ResponseBody ChatSessionDTO closeSession(@PathVariable Long sessionId) {
        ChatSession session = sessionService.find(sessionId);
        return sessionService.sessionClose(session);
    }

    @RequestMapping(value = "/{sessionId}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteSession(@PathVariable Long sessionId) {
        ChatSession session = sessionService.find(sessionId);
        sessionService.deleteSession(session);
        return "Success";
    }
}
