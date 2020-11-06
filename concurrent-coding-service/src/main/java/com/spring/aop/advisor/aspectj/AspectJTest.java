package com.spring.aop.advisor.aspectj;/**
 * @author
 * @since 2020-10-20 15:48
 */

import com.spring.aop.advisor.*;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName AspectJTest.java
 * @Description
 * @createTime 2020年10月20日 15:48:00
 */
public class AspectJTest {

    public static void main(String[] args) {
//        codingAspectJAdvistor();
//        springConfigAspctJAdvistor();
        advistorExecuteOrder();
    }


    private static void codingAspectJAdvistor() {
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        Waiter waiterTarget = new NavieWaiter();
        aspectJProxyFactory.setTarget(waiterTarget);

        aspectJProxyFactory.addAspect(AspectJAdvistor.class);

        Waiter waiter = aspectJProxyFactory.getProxy();
        waiter.greetTo("test");
    }

    private static void springConfigAspctJAdvistor() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aspectj.xml");

        //使用基于cglib动态代理才能做此强转换
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("waiter");
        waiter.greetTo("join test");
    }

    private static void advistorExecuteOrder() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aspectj.xml");
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("waiter");
        waiter.greetTo("join test");
    }
}
