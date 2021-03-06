package com.spring.learning.beanfactory.lifecycle;/**
 * @author
 * @since 2020-09-14 20:53
 */

import java.beans.PropertyDescriptor;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.Ordered;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName MyInstantiationAwareBeanPostProcessor.java
 * @Description
 * @createTime 2020年09月14日 20:53:00
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements Ordered {


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation="
                + beanClass.getSimpleName() + ",beanName=" + beanName);
        return null;

    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation bean="
                + bean + ",beanName=" + beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("调用InstantiationAwareBeanPostProcessor.postProcessPropertyValues pvs="
                + pvs + ",beanName=" + beanName);
        return pvs;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
