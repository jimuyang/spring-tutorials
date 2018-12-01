package muyi.spring.rest.component;

import org.springframework.stereotype.Component;

/**
 * @author: Jimu Yang
 * @date: 2018/11/26 11:42 PM
 * @descricption: want more.
 */
@Component
public class HelloComponent {


    public String componentHello() {
        return this.getClass().getName() + " say hi!";
    }

    public String testArgType (int i, char c, short sh, long lo, byte by) {
        return "test arg type";
    }

}
