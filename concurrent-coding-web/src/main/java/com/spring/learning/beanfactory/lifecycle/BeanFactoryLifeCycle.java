package com.spring.learning.beanfactory.lifecycle;/**
 * @author
 * @since 2020-09-14 20:42
 */

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName BeanFactoryLifeCycle.java
 * @Description Spring BeanFactory 创建bean 生命周期等测试
 * @createTime 2020年09月14日 20:42:00
 */
public class BeanFactoryLifeCycle {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("/spring/spring-bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        ((XmlBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        ((XmlBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        ((XmlBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor1());
        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        System.out.println("==========================");
        Car car2 = (Car) beanFactory.getBean("car");
        System.out.println(car2 == car);
        System.out.println("==========================");


        Cat cat = (Cat) beanFactory.getBean("cat");
        System.out.println(cat);

        System.out.println("==========================");

        ((XmlBeanFactory) beanFactory).destroySingletons();
    }
}
