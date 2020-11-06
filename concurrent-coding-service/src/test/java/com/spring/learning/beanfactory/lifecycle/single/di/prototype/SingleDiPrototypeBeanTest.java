package com.spring.learning.beanfactory.lifecycle.single.di.prototype;/**
 * @author
 * @since 2020-10-12 20:57
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName SingleDiPrototypeBean.java
 * @Description:单实例bean中注入scope 为prototype类型的bean
 * @createTime 2020年10月12日 20:57:00
 */
public class SingleDiPrototypeBeanTest {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-bean.xml");
        Boss boss = (Boss) ctx.getBean("boss");
        Car car1 = boss.getCar();
        System.out.println("car1=" + car1);

        Car car2 = boss.getCar();
        System.out.println("car2=" + car2);
    }
}
