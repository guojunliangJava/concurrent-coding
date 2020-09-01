package com.spring.aop.service.impl;/**
 * @author
 * @since 2020-07-03 13:24
 */

import com.spring.aop.aspect.TimeAnnotation;
import com.spring.aop.service.IhelloWorldService;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName HelloWorldServiceImpl.java
 * @Description
 * @createTime 2020年07月03日 13:24:00
 */
public class HelloWorldServiceImpl implements IhelloWorldService {


    @Override
    public void sayAdvisorBefore(String param) {
        System.out.println("HelloWorldServiceImpl.sayAdvisorBefore:" + param);
    }


    @Override
    public void sayAdvisorBefore(String param, String name, Integer age) {
        System.out.println("HelloWorldServiceImpl.sayAdvisorBefore3:" + param + ",name=" + name + ",age=" + age);

    }
}
