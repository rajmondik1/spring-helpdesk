package lt.is.helpdesk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/test2")
    public String index() {
        return "Welcome!";
    }

    @RequestMapping("/test")
    public String test() {
        return "test route!";
    }
}
