package com.spring.learning.beanfactory.lifecycle;/**
 * @author
 * @since 2020-09-21 21:12
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ApplicationContextLifeCycle.java
 * @author guojl
 * @version 1.0.0
 * @Description ApplicationContext相关测试
 * @createTime 2020年09月21日 21:12:00
 */
public class ApplicationContextLifeCycle {

    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("/spring/spring-bean.xml");

        Car car  = (Car) context.getBean("car");
        System.out.println(car.getBrand());
    }
}
