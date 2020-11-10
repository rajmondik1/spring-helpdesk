package lt.is.helpdesk.controller;

import lt.is.helpdesk.service.WebSocketConnectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TokenController {
    @RequestMapping("/token")
    public String token() {
        String uuid = UUID.randomUUID().toString();
        WebSocketConnectionService.getInstance().connections.add(uuid);
        return uuid;
    }
}
