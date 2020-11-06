package com.spring.aop;/**
 * @author
 * @since 2020-10-15 16:17
 */

import java.lang.reflect.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName JDKProxyTest.java
 * @Description
 * @createTime 2020年10月15日 16:17:00
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        CustomServiceImpl customService = new CustomServiceImpl();

        InvocationHandler invocationHandler = new CustomInvocationHandler(customService);

        CustomService proxyObject =
                (CustomService)Proxy.newProxyInstance(customService.getClass().getClassLoader(), customService.getClass().getInterfaces(), invocationHandler);
        proxyObject.removeTopic();


    }
}
