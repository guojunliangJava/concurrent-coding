/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreadLocalTest
 * Author:   guojunliang
 * Date:     2019/4/29 17:50
 * Description: ThreadLocal测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.concurrent;

/**
 * 〈一句话功能简述〉<br>
 * 〈ThreadLocal测试〉
 *
 * @author guojunliang
 * @create 2019/4/29
 * @since 1.0.0
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.get();
        threadLocal.set("test");

    }

}