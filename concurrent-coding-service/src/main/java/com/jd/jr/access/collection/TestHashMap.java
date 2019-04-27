package com.jd.jr.access.collection;

import java.util.HashMap;

/**
 * hashMap红黑树讲解参考： https://www.cnblogs.com/mfrank/p/9227097.html
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>(12);
        System.out.println(hashMap);
    }
}
