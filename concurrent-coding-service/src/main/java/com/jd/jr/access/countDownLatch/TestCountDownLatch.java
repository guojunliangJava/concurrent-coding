/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestCountDownLatch
 * Author:   guojunliang
 * Date:     2019/4/26 10:00
 * Description: 测试线程同步countDownLatch
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试线程同步countDownLatch〉
 * 参考:http://www.importnew.com/15731.html
 * <p>
 * CountDownLatch是在java1.5被引入的，跟它一起被引入的并发工具类还有CyclicBarrier、Semaphore、ConcurrentHashMap和BlockingQueue，它们都存在于java.util.concurrent包下。CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行。例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有的框架服务之后再执行。
 * <p>
 * CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就会减1。当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 *
 * @author guojunliang
 * @create 2019/4/26
 * @since 1.0.0
 */
public class TestCountDownLatch {

    /*public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("main thread Execute finish!,耗时=" + (System.currentTimeMillis() - startTime));
    }*/

    /**
     * 使用countDownLatch使得主线程等待子线程执行完成后,再进行执行
     *
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int forCount = 50000;
        final CountDownLatch countDownLatch = new CountDownLatch(forCount);
        for (int i = 0; i < forCount; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
//            countDownLatch.await();
            countDownLatch.await(50, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread Execute finish!,耗时=" + (System.currentTimeMillis() - startTime));
    }

}