package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 17:18
 */

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName TestBeforeAdvice.java
 * @Description
 * @createTime 2020年10月19日 17:18:00
 */
public class TestBeforeAdvice {

    public static void main(String[] args) {
//        newProxyInstance();

//        newProxyInstanceSpringJDK();
//        newProxyInstanceSpringCglib();
//        newProxyInstanceSpringAoundAdvice();
        newProxyInstanceSpringIntroductionInterceptor();
    }


    private static void newProxyInstance() {
        Waiter waiter = new NavieWaiter();
        GreetBeforeAdvice beforeAdvice = new GreetBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAdvice(beforeAdvice);

        Waiter waiterTarget = (Waiter) proxyFactory.getProxy();

        waiterTarget.greetTo("jone");
        waiterTarget.serviceTo("jone");
    }

    private static void newProxyInstanceSpringJDK() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aop.xml");
        Waiter waiter = (Waiter) ctx.getBean("navieWaiter");
        waiter.greetTo("Spring jone");
        waiter.serviceTo("Spring jone");


    }

    private static void newProxyInstanceSpringCglib() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aop.xml");
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("navieWaiterCglib");
        waiter.greetTo("Spring jone");
        waiter.serviceTo("Spring jone");
        waiter.childMethod("cglib");


    }

    private static void newProxyInstanceSpringAoundAdvice() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aop.xml");
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("navieWaiterAound");
        waiter.greetTo("Spring jone");
        waiter.serviceTo("Spring jone");
        waiter.childMethod("cglib");
    }

    private static void newProxyInstanceSpringIntroductionInterceptor() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-aop.xml");
        NavieWaiter waiter = (NavieWaiter) ctx.getBean("navieWaiterTargetStaticGreetAdvisor");
        waiter.greetTo("Spring jone");
        waiter.serviceTo("Spring jone");

        MonitorSwitch monitorSwitch = (MonitorSwitch) waiter;
        monitorSwitch.setMonitorSwitch(true);
        System.out.println("引介增强测试!");
        waiter.greetTo("Spring jone");
        waiter.serviceTo("Spring jone");
        waiter.childMethod("cglib");

    }


}
