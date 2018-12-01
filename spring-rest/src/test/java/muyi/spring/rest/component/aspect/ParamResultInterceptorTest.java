package muyi.spring.rest.component.aspect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

import static muyi.spring.rest.util.ClassUtil.*;
import static org.junit.Assert.*;

/**
 * @author: Jimu Yang
 * @date: 2018/11/27 5:12 PM
 * @descricption: want more.
 */
public class ParamResultInterceptorTest {

    @Test
    public void test() {
        assert isList(ArrayList.class);
        assert isList(LinkedList.class);
        assert !isList(Object.class);

        int[] intArray = new int[10];
        assert isArray(intArray.getClass());

        assert isBaseType(int.class);
        assert !isBaseType(Object.class);
    }

    @Test
    public void testReflect() {
        Map<String, String> stringMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        Field[] fields = stringMap.getClass().getDeclaredFields();
        Method[] methods = stringMap.getClass().getMethods();

        Field field = fields[0];
        Type type = field.getGenericType();

        methods = list.getClass().getMethods();

        return;
    }

}