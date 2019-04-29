/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreadPoolTest
 * Author:   guojunliang
 * Date:     2019/4/29 16:35
 * Description: 线程池原理分析测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池原理分析测试〉
 * //TODO 未完成学习
 * 参考:http://ifeve.com/java-threadpoolexecutor/
 * @author guojunliang
 * @create 2019/4/29
 * @since 1.0.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new ThreadTask());
    }

    private static class ThreadTask implements Runnable {

        @Override
        public void run() {
            System.out.println("test thread pool");
        }
    }

}