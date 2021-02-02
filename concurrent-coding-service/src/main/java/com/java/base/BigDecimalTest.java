package com.java.base;/**
 * @author
 * @since 2020-09-21 10:21
 */

import java.math.BigDecimal;

/**
 * @ClassName BigDecimalTest.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年09月21日 10:21:00
 */
public class BigDecimalTest {

    //BigDecimal compareTo() 以及eqeals()方法对比

    public static void main(String[] args) {


        BigDecimal bigDecimal = new BigDecimal(1);

        BigDecimal bigDecimal1 = new BigDecimal(1);

//        System.out.println(bigDecimal.equals(bigDecimal1));


        BigDecimal bigDecimal2 = new BigDecimal(2.00);

        BigDecimal bigDecimal3 = new BigDecimal(2.0);

        System.out.println(bigDecimal2.equals(bigDecimal3));


        BigDecimal bigDecimal4 = new BigDecimal("1");

        BigDecimal bigDecimal5 = new BigDecimal("1.0");

        System.out.println(bigDecimal4.equals(bigDecimal5));

    }
}
