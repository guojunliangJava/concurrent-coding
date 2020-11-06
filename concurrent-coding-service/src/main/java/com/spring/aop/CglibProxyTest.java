package com.spring.aop;/**
 * @author
 * @since 2020-10-15 16:47
 */

/**
 * @ClassName CglibProxyTest.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月15日 16:47:00
 */
public class CglibProxyTest {
    public static void main(String[] args) {

        CglibProxy cglibProxy = new CglibProxy();
        CustomServiceImpl customService = (CustomServiceImpl)cglibProxy.getProxy(CustomServiceImpl.class);
        customService.removeTopic();
        customService.add();
        customService.add1();
    }
}
