package com.spring.beanfactory.circle.setter;/**
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
        CircleA circleA = (CircleA) applicationContext.getBean("setterCircleA");
        System.out.println(circleA);
        System.out.println(circleA.getCircleB());

        ((ClassPathXmlApplicationContext) applicationContext).close();

    }
}
