package co.edu.uco.reactiveexample.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/public-message")
    @SendTo("/topic/public-chat")
    public ChatResponseDTO notifyAllSubscribers(ChatRequestDTO request) {
        var dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        return new ChatResponseDTO(request.message(), dateTime);
    }

    @MessageMapping("/connect-user")
    @SendToUser("/topic/connected-users")
    public String connect(SimpMessageHeaderAccessor sessionInformation) {
        return "User connected successfully with session id: ".concat(sessionInformation.getSessionId());
    }
}