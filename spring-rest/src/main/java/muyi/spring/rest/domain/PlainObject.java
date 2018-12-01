package muyi.spring.rest.domain;

import lombok.Data;

/**
 * @author: Jimu Yang
 * @date: 2018/11/27 3:33 PM
 * @descricption: want more.
 */

@Data
public class PlainObject extends Parent{

    private String mobile;

    private InnerObject inner;

    @Data
    public static class InnerObject {

        private String phone;

    }
}


