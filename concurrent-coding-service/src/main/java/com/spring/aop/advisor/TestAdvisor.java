package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 21:21
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName TestAdvisor.java
 * @Description
 * @createTime 2020年10月19日 21:21:00
 */
public class TestAdvisor {

    public static void main(String[] args) {

//        newProxyInstanceStaticAdvisor();
        newProxyInstanceDynamicAdvisor();
    }

    private static void newProxyInstanceStaticAdvisor() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aop.xml");
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("navieWaiterTargetStaticGreetAdvisor");
        waiter.greetTo("Spring jone");
        waiter.serviceTo("Spring jone");

        Seller seller = (Seller) ctx.getBean("sellerImplTargetStaticGreetAdvisor");
        seller.greetTo("testSeller");

    }

    /**
     * 动态切面测试
     */
    private static void newProxyInstanceDynamicAdvisor() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aop.xml");
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("navieWaiterTargetDynamicGreetAdvisor");
        waiter.greetTo("Spring jone");
        waiter.greetTo("dynamicMatch");
//        waiter.serviceTo("Spring jone");

        Seller seller = (Seller) ctx.getBean("sellerImplTargetDynamicGreetAdvisor");
        seller.greetTo("testSeller");


    }




}
