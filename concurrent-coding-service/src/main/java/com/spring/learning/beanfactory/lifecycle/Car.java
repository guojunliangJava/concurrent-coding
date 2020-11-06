package com.spring.learning.beanfactory.lifecycle;/**
 * @author
 * @since 2020-09-14 20:44
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName Car.java
 * @Description
 * @createTime 2020年09月14日 20:44:00
 */
public class Car implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String brand;
    private String color;

    public Car() {
        System.out.println("调用Car()构造方法!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory() 方法");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBeanName设置Bean Name");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy() 方法");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet() 方法");

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand设置属性值");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("调用setColor设置属性值");
        this.color = color;
    }

    public void initMethod(){
        System.out.println("调用 init-method 中声明的方法");
    }


    public void destoryMethod(){
        System.out.println("调用 destory-method 中声明的方法");
    }
}
