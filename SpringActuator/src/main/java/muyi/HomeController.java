package muyi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{

    //@RestController combines @Controller and @ResponseBody

    @RequestMapping("/")
    public String home(){
        return "Greetings from muyi!";
    }




}