package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 20:59
 */

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName SellerImpl.java
 * @Description
 * @createTime 2020年10月19日 20:59:00
 */
public class SellerImpl implements Seller {
    @Override
    public void greetTo(String name) {
        System.out.println("seller:greetTo=" + name);
    }
}
