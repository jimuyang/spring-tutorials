package hello;

import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.dto.Greeting;

@RestController
public class GreetingController{

    private static final String template = "hello, %s";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name",defaultValue="world")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/user")
    public UserBean findUser(@RequestParam(value="name",defaultValue="muyi")String name){
        return new UserBean(name);
    }



}
class UserBean{
    private String name;
    private String blog;

    public UserBean(String name){
        this.name = name;
        this.blog = name + "blog";
    }

     /**
     * @return the blog
     */
    public String getBlog() {
        return blog;
    }
    /**
     * @param blog the blog to set
     */
    public void setBlog(String blog) {
        this.blog = blog;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }



}