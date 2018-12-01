package muyi.spring.rest.controller;

import lombok.extern.slf4j.Slf4j;
import muyi.spring.rest.component.HelloComponent;
import muyi.spring.rest.domain.PlainObject;
import muyi.spring.rest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Jimu Yang
 * @date: 2018/11/27 4:07 PM
 * @descricption: want more.
 */
@Controller
@RequestMapping("/hello")
@Slf4j
public class HelloController {


    @Autowired
    private HelloComponent helloComponent;

    @Autowired
    private HelloService helloService;

    @GetMapping("/index")
    @ResponseBody
    public PlainObject index() {
//        log.info("Integer 是基本类型？{}", Integer.class.isPrimitive());
//        log.info("Byte 是基本类型？{}", Integer.class.isPrimitive());
//        log.info("String 是基本类型？{}", String.class.isPrimitive());

        log.info(helloComponent.componentHello());
        PlainObject po = new PlainObject();
        po.setMobile("131****1111");
        po.setInner(new PlainObject.InnerObject());
        po.getInner().setPhone("131****9999");
        PlainObject result = helloService.tryDo(po, 90, "190****6666");
        return result;
    }

}
