package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 19:48
 */

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName GreetAfterReturnAdvice.java
 * @Description
 * @createTime 2020年10月19日 19:48:00
 */
public class GreetAfterReturnAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        System.out.println("enjoy yourSelf=" + o1);

    }
}
