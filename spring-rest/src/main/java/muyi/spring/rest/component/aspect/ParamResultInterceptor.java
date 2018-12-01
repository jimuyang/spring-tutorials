package muyi.spring.rest.component.aspect;

import com.sun.deploy.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import muyi.spring.rest.service.CommonService;
import muyi.spring.rest.util.ClassUtil;
import muyi.spring.rest.util.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Jimu Yang
 * @date: 2018/11/26 11:45 PM
 * @descricption: want more.
 */
@Component
@Aspect
@Slf4j
public class ParamResultInterceptor {

    @Pointcut("@within(org.springframework.stereotype.Service) && !execution(* muyi.spring.rest.service.CommonService.*(..))")
    public void serviceMethod() {
    }

    @Autowired
    private CommonService commonService;


    @Around("serviceMethod()")
    public Object handleParamAndResult(ProceedingJoinPoint pjp) throws Throwable {
        //
        commonService.sayCommon();

        // start stopwatch
        log.info("[HandleParamResult] find pointcut: {}", pjp.toString());
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        log.info("===> signature: {}", methodSignature);

        String[] argNames = methodSignature.getParameterNames();
        List<String> temp = Arrays.asList(argNames);
        log.info("===> argNames: {}", temp);
        Class[] argTypes = methodSignature.getParameterTypes();
        Object[] argValues = pjp.getArgs();
        log.info("===> args: {}", argValues);

        long time = System.nanoTime();
        log.info("开始解密====>");
        handleArgs(argValues, argNames, argTypes);
        log.info("解密结束..... 耗时 {} ns", System.nanoTime() - time);
        time = System.nanoTime();
        log.info("开始执行====>");
        Object retVal = pjp.proceed(argValues);
        log.info("执行结束..... 耗时 {} ns", System.nanoTime() - time);

//        Object proxy = pjp.getThis();
//        log.info("===> proxy: {}", proxy);
//        Object target = pjp.getTarget();
//        log.info("===> target: {}", target);

        // stop stopwatch
        return retVal;
    }

    private void handleArgs(Object[] argValues, String[] argNames, Class[] argTypes) {
        if (argValues == null || argValues.length == 0) {
            return;
        }
        int argNum = argValues.length;

        assert argNum == argNames.length;
        assert argNum == argTypes.length;

        for (int i = 0; i < argNum; i++) {
            MethodSignatureArg newArg = newArg(new MethodSignatureArg(argValues[i], argNames[i], argTypes[i]));
            argValues[i] = newArg.getValue();
        }
    }

    private static final List<String> POSSIBLE_MOBILE_ARG_NAMES = Arrays.asList("mobile", "phone", "phonenumber", "no", "keyword");


    private MethodSignatureArg newArg(MethodSignatureArg oldArg) {
        // 暂时不抽象 这里直接写下进行手机号参数的判断和处理
        if (oldArg.getType().equals(String.class) && POSSIBLE_MOBILE_ARG_NAMES.contains(oldArg.getName().toLowerCase())) {
            // 这个参数是手机号
            String mobile = (String) oldArg.getValue();
            log.info("【MOBILE】原手机号为：{}", mobile);
            mobile = decrypt(mobile);
            oldArg.setValue(mobile);
            return oldArg;

        } else if (ClassUtil.isPOJO(oldArg.getType())) {
            // 这个参数是普通对象POJO
            handleMobileInPOJO(oldArg.getValue(), oldArg.getType(), 0);
            return oldArg;
        }
        return oldArg;
    }

    /**
     * 处理POJO中的手机号属性
     */
    private void handleMobileInPOJO(Object value, Class<?> type, int round) {
        if (value == null || !ClassUtil.isPOJO(type) || round > 3) {
            return;
        }

        Method[] methods = type.getMethods();
        for (Method method : methods) {
            // 处理无参get方法
            if (method.getName().startsWith("get") && method.getParameterCount() < 1) {
                String nameNoPrefix = method.getName().replaceFirst("get", "");

                if (method.getReturnType().equals(String.class)
                        && POSSIBLE_MOBILE_ARG_NAMES.contains(nameNoPrefix.toLowerCase())) {
                    // 这是手机号的get方法
                    try {
                        String mobile = (String) method.invoke(value);
                        log.info("【MOBILE】原手机号为：{}", mobile);
                        // 尝试调用set方法
                        Method setMethod = type.getMethod("set" + nameNoPrefix, String.class);
                        mobile = decrypt(mobile); // decrypt
                        setMethod.invoke(value, mobile);
                    } catch (NoSuchMethodException nsme) {
                        log.error("【MOBILE】解密找不到set方法: {}", nsme.getMessage());
                    } catch (Exception e) {
                        log.error("【MOBILE】通过反射将参数中的手机号解密失败", e);
                    }
                } else if (ClassUtil.isPOJO(method.getReturnType())) {
                    // 这是POJO的get方法
                    try {
                        Object pojo = method.invoke(value);
                        // 递归处理
                        handleMobileInPOJO(pojo, method.getReturnType(), ++round);
                    } catch (Exception e) {
                        log.error("【MOBILE】递归处理POJO失败", e);
                    }
                }
            }
        }
    }


    private static String decrypt(String mobile) {
        if (mobile == null) {
            return null;
        }
//        return mobile.replaceFirst("/^(\\d{3})\\*\\*\\*\\*(\\d{4})$/", "$1abcd$2");
        return "解密的手机号";
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MethodSignatureArg {

        private Object value;

        private String name;

        private Class<?> type;

    }


}
