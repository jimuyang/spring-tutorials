package muyi.spring.rest.service.impl;

import muyi.spring.rest.domain.PlainObject;
import muyi.spring.rest.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author: Jimu Yang
 * @date: 2018/11/26 11:41 PM
 * @descricption: want more.
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public PlainObject tryDo(PlainObject poInImpl, int id, String no) {
        poInImpl.setId(id);
        poInImpl.setNo(no);
        return poInImpl;
    }

}
