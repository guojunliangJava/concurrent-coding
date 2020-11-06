package com.spring.learning.beanfactory.lifecycle;/**
 * @author
 * @since 2020-09-14 21:01
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName MyBeanPostProcessor.java
 * @Description
 * @createTime 2020年09月14日 21:01:00
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization方法,bean="
                + o + "beanName=" + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("调用BeanPostProcessor.postProcessAfterInitialization,bean="
                + o + "beanName=" + s);
        return o;
    }
}
