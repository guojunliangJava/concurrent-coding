package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 19:54
 */

import org.aopalliance.intercept.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName GreetAroundAdvice.java
 * @Description
 * @createTime 2020年10月19日 19:54:00
 */
public class GreetAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around Advice:method before");
        Object obj = invocation.proceed();
        System.out.println("around Advice:method after");
        return obj;
    }
}
