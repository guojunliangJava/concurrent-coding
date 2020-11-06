package com.spring.beanfactory;/**
 * @author
 * @since 2020-10-13 10:56
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName CarBeanFactory.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月13日 10:56:00
 */
public class CarFactoryBeanTest{

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-bean.xml");

        Car1 car = (Car1) ctx.getBean("carFactoryBean");
        System.out.println(car);

        Car1 car1 = (Car1) ctx.getBean("carFactoryBean");
        System.out.println(car1);
        System.out.println( ctx.getBean("&carFactoryBean"));
    }


}
