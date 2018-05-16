package websocket.chat;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/from:app");//服务器监听客户端地址前缀，客户端通过此地址前缀向服务器发送消息
        registry.enableSimpleBroker("/from:server");//发送给客户端消息的地址前缀，客户端可以绑定监听此地址前缀
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //提供端点绑定
        registry.addEndpoint("/chat").withSockJS();
    }
}
