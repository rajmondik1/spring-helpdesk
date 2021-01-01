package lt.is.helpdesk.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Deprecated
public class WebSocketConnectionService {
    private static final WebSocketConnectionService instance = new WebSocketConnectionService();
    public ArrayList<String> connections = new ArrayList<String>();

    private WebSocketConnectionService(){}

    public static WebSocketConnectionService getInstance() {
        return instance;
    }
}
