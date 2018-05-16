package websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import websocket.chat.javabeans.Greeting;
import websocket.chat.javabeans.User;

@Controller
public class LoginController {

    @MessageMapping("/login")
    @SendTo("/from:server/greetings")
    public Greeting login(User user) {
        return new Greeting(user.getName() + " join the group chat...");
    }

    @MessageMapping("/logout")
    @SendTo("/from:server/greetings")
    public Greeting logout(User user) {
        return new Greeting(user.getName() + " left the group chat...");
    }
}
