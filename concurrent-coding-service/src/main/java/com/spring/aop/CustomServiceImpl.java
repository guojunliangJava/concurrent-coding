package com.spring.aop;/**
 * @author
 * @since 2020-10-15 16:12
 */

/**
 * @ClassName CustomServiceImpl.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月15日 16:12:00
 */
public class CustomServiceImpl implements CustomService {

    @Override
    public void removeTopic() {
        System.out.println("removeTopic execute!!!");
    }

    protected void add(){
        System.out.println("add");
    }

    final void add1(){
        System.out.println("add1");
    }
}
