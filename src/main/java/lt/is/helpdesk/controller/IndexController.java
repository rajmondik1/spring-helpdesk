package lt.is.helpdesk.controller;

import lt.is.helpdesk.service.WebSocketConnectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "Welcome!";
    }

    @RequestMapping("/count")
    public String count(HttpServletResponse response) {
        response.setContentType("application/json");
        return WebSocketConnectionService.getInstance().connections.toString();
    }


    // TODO: Monitor all websocket connections
}
