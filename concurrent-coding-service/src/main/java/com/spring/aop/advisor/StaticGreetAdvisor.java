package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 21:00
 */

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName StaticGreetAdvisor.java
 * @Description
 * @createTime 2020年10月19日 21:00:00
 */
public class StaticGreetAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().equals("greetTo");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
