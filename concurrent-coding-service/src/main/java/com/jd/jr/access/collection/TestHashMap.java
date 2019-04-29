package com.jd.jr.access.collection;

import java.util.HashMap;

/**
 * hashMap红黑树讲解参考： https://www.cnblogs.com/mfrank/p/9227097.html
 * hashMap多线程并发扩容 resize -->transfer()时,形成死循环:参考:https://coolshell.cn/articles/9606.html
 * 参考:https://blog.csdn.net/weixin_34341229/article/details/86303711
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.put("3", "3");
        hashMap.put("4", "4");
        hashMap.put("5", "5");
        hashMap.put("6", "6");
        hashMap.put("7", "7");
        hashMap.put("8", "8");
        hashMap.put("9", "9");
        hashMap.put("10", "10");

//        hashMap.put("1", "1");
//        hashMap.put("2", "2");

        hashMap.put("11", "11");
        hashMap.put("12", "12");
        hashMap.put("13", "13");
        hashMap.put("14", "14");
        //TODO 扩容
        hashMap.put("15", "15");
        hashMap.put("16", "16");
        hashMap.put("17", "17");
        hashMap.put("18", "18");

        hashMap.put("19", "19");
        hashMap.put("20", "20");
        System.out.println(hashMap);
    }
}
