package muyi.spring.rest.service.impl;

import muyi.spring.rest.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @author: Jimu Yang
 * @date: 2018/11/28 6:30 PM
 * @descricption: want more.
 */
@Service
public class CommonServiceImpl implements CommonService {


    @Override
    public String sayCommon() {
        return this.getClass().getName();
    }
}
