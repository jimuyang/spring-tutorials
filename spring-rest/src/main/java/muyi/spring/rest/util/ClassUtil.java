package muyi.spring.rest.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: Jimu Yang
 * @date: 2018/11/27 5:19 PM
 * @descricption: want more.
 */
public class ClassUtil {

    /**
     * 判断一个class是不是基本类型
     */
    public static boolean isBaseType(Class clazz) {
        return clazz.isPrimitive();
    }

    /**
     * 判断一个class是不是基本类型或者基本类型的包装
     */
    public static boolean isBaseTypeOrWrapper(Class clazz) {
        if (isBaseType(clazz)) {
            return true;
        }
        if (clazz.equals(Integer.class)
                || clazz.equals(Byte.class)
                || clazz.equals(Long.class)
                || clazz.equals(Double.class)
                || clazz.equals(Float.class)
                || clazz.equals(Character.class)
                || clazz.equals(Short.class)
                || clazz.equals(Boolean.class)
                || clazz.equals(Void.class)) {
            return true;
        }
        return false;
    }

    /**
     * 判断class是不是数组类型
     */
    public static boolean isArray(Class clazz) {
        return clazz.isArray();
    }

    /**
     * 判断class是不是List类型
     */
    public static boolean isList(Class clazz) {
        return List.class.isAssignableFrom(clazz);
    }


    /**
     * 判断class是不是Map类型
     */
    public static boolean isMap(Class clazz) {
        return Map.class.isAssignableFrom(clazz);
    }

    /**
     * 判断class是不是set类型
     */
    public static boolean isSet(Class clazz) {
        return Set.class.isAssignableFrom(clazz);
    }


    /**
     * 判断class是不是POJO
     * 普通的object
     */
    public static boolean isPOJO(Class clazz) {
        return !(isBaseTypeOrWrapper(clazz)
                || isArray(clazz)
                || isMap(clazz)
                || isSet(clazz)
                || isList(clazz)
        );
    }
}
