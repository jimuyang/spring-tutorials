package muyi.spring.rest.util;

/**
 * @author: Jimu Yang
 * @date: 2018/11/28 10:39 AM
 * @descricption: want more.
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0 || "null".equals(str);
    }
}
