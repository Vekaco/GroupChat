package websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import websocket.chat.javabeans.MessageIn;
import websocket.chat.javabeans.MessageOut;

@Controller
public class MessageController {

    @MessageMapping("/messaging")
    @SendTo("/from:server/messaging")
    public MessageOut messaging(MessageIn message){
        return new MessageOut(message.getName() + " : " + message.getMessage());
    }
}
