package com.spring.learning.beanfactory.lifecycle;/**
 * @author
 * @since 2020-09-21 21:14
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;

/**
 * @ClassName MyBeanFactoryPostProcessor.java
 * @author guojl
 * @version 1.0.0
 * @Description BeanFactoryPostProcessor相关测试
 * @createTime 2020年09月21日 21:14:00
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("car");

        beanDefinition.getPropertyValues().add("brand","宝马");

        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory方法");

    }
}
