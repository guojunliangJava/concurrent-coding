package com.spring.beanfactory;/**
 * @author
 * @since 2020-12-08 20:32
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName CarInstanceTest.java
 * @Description
 * @createTime 2020年12月08日 20:32:00
 */
public class CricleTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-beans.xml");
        CircleA circleA = (CircleA) applicationContext.getBean("circleA");
        System.out.println(circleA);
        System.out.println(circleA.getCircleB());

         circleA = (CircleA) applicationContext.getBean("circleA");
        System.out.println(circleA);
        System.out.println(circleA.getCircleB());

        CircleB circleB_2 = (CircleB) applicationContext.getBean("circleB_2");
        System.out.println(circleB_2);
        System.out.println(circleB_2.getCircleC());

         circleB_2 = (CircleB) applicationContext.getBean("circleB_2");
        System.out.println(circleB_2);
        System.out.println(circleB_2.getCircleC());

        System.out.println("多例Ban 之间构造器注入");
        CircleB circleB_3 = (CircleB) applicationContext.getBean("circleB_3");
        System.out.println(circleB_3);
        System.out.println(circleB_3.getCircleC());

        circleB_3 = (CircleB) applicationContext.getBean("circleB_3");
        System.out.println(circleB_3);
        System.out.println(circleB_3.getCircleC());
    }
}
