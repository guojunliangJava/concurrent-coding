package com.spring.aop;/**
 * @author
 * @since 2020-10-15 16:13
 */

import java.lang.reflect.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName CustomInvocationHandler.java
 * @Description
 * @createTime 2020年10月15日 16:13:00
 */
public class CustomInvocationHandler implements InvocationHandler {

    private Object target;

    public CustomInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk proxy aop begin ");

        Object object = method.invoke(target, args);

        System.out.println("jdk proxy aop end ");
        return object;

    }
}
