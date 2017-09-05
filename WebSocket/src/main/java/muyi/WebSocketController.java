package muyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController{

    private SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    /**
     * @return the template
     */
    public SimpMessagingTemplate getTemplate() {
        return template;
    }

    @MessageMapping("/greeting") //@MessageMapping接收客户端消息
    @SendTo("/topic/greetings")  //@SendTo广播消息出去
    public HelloContent hello(HelloMessage message) throws Exception{
        Thread.sleep(1000);
        return new HelloContent("Hello, I am " + message.getName());

    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public HelloContent sendMessageToUser(HelloMessage message) throws Exception{
        Thread.sleep(1000);
        return new HelloContent("Hello, " + message.getName());
    }



}