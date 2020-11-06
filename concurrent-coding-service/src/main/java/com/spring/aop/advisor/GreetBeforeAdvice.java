package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 17:17
 */

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName GreetBeforeAdvice.java
 * @Description
 * @createTime 2020年10月19日 17:17:00
 */
public class GreetBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = (String) objects[0];
        System.out.println("How are you " + name);

    }
}
