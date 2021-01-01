## HelpDesk app spring boot backend

OpenJDK version 15

### Startup
1. Run run the project using built in IDEA tools
2. Go to ```localhost:8080```
3. Develop

### Current architecture

HelpDeskApplication
- config/
    - **WebSocketConfig** *Websocket configuration methods*
- controller/
    - **ChatController** *Main websocket and REST endpoints messages*
    - **SessionController** *ChatSession REST endpoints*
- dto/
    - **ChatMessageDTO** *Chat message return object*
    - **ChatSessionDTO** *Chat session return object for list*
- entity/
    - **ChatMessage** *Message data*
    - **ChatSession** *Session info with ref to messages*
    - **ChatSessionStatus** *Enum for session status*
- repository/
    - *Repositories for entities*
- service/
    - **ChatMessageService** *Message service for all interactions with repo and business logic*
    - **ChatSessionService** *Session service for all interactions with repo and business logic*
