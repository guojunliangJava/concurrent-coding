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
public class CarInstanceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-beans.xml");
        CarWithOutDefaultConstruct car1 = (CarWithOutDefaultConstruct) applicationContext.getBean("carWithOutDefaultConstruct");
        System.out.println(car1.getColor());
    }
}
