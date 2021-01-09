package lt.is.helpdesk.dto;

import lt.is.helpdesk.entity.ChatSessionStatus;

public class ChatSessionDTO {
    private Long id;
    private ChatSessionStatus status;

    public ChatSessionDTO(Long id, ChatSessionStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public ChatSessionStatus getStatus() {
        return status;
    }
}
