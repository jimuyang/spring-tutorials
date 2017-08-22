package hello;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController{

    private static final String template = "hello, %s";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue="world")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}