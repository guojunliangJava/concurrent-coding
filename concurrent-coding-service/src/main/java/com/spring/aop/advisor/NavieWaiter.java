package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 17:16
 */

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName NavieWaiter.java
 * @Description
 * @createTime 2020年10月19日 17:16:00
 */
public class NavieWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to=" + name);
    }

    @Override
    public void serviceTo(String anme) {

        System.out.println("service to =" + anme);
    }

    void childMethod(String name) {
        System.out.println("child Method=" + name);
    }
}
