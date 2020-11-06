package com.spring.component.autowired;/**
 * @author
 * @since 2020-10-13 14:45
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName autoScanAndAutowiredTest.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月13日 14:45:00
 */
public class AutoScanAndAutowiredTest {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-context.xml");

        Animal dog = (Animal) ctx.getBean("dog");
        System.out.println(dog);

        Animal fish = (Animal) ctx.getBean("fish");
        System.out.println(fish);
    }
}
