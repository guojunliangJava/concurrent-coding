package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-20 10:56
 */

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName GreetDynamicMethodAdvistor.java
 * @Description
 * @createTime 2020年10月20日 10:56:00
 */
public class GreetDynamicMethodPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("动态检查:matches=" + aClass.getName() + "method=" + method.getName() + ",objects=" + objects);
//        System.out.println("***********end************");
        String name = (String) objects[0];
        if (name.equals("dynamicMatch")) {
            return true;
        }
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("静态检查:classFilter=" + aClass.getName());
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("静态检查:matches=" + targetClass.getName() + "method=" + method.getName());
        System.out.println("***********end************");
        return method.getName().equals("greetTo");
    }
}
