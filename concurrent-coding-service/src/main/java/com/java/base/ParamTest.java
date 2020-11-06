package com.java.base;/**
 * @author
 * @since 2020-09-28 20:40
 */

import java.util.ArrayList;

/**
 * @ClassName ParamTest.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年09月28日 20:40:00
 */
public class ParamTest {

    public static void main(String[] args) {
        Object obj =new Object();
        System.out.println(obj);
        test(obj);
        System.out.println(obj);

    }

    static void test(Object obj){
        obj =  new ArrayList();
        System.out.println(obj);
    }
}
