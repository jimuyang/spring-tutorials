
package muyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController{

    @Autowired 
    private WebSocketController webSocketController;

    @MessageMapping("/helloAll")
    public void helloAll(HelloMessage message){
        webSocketController.getTemplate().convertAndSend("/topic/greetings",new HelloContent("Hello everyone, I am " + message.getName()));
    }


    @MessageMapping("/hello")
    public void hello(HelloMessage message){
        webSocketController.getTemplate().convertAndSendToUser(message.getName(), "/message", new HelloContent("Hello, " + message.getName()));
    }
}