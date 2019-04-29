/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SemaphoreTest
 * Author:   guojunliang
 * Date:     2019/4/29 15:11
 * Description: Semaphore(信号量测试)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.collection;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 〈一句话功能简述〉<br>
 * 〈Semaphore(信号量测试)〉
 * 参考:https://www.cnblogs.com/XHJT/p/3910406.html
 * https://www.cnblogs.com/stonefeng/p/5967451.html
 *
 * @author guojunliang
 * @create 2019/4/29
 * @since 1.0.0
 */
public class SemaphoreTest {
    //***************************************first begin************************************************
   /* public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final Semaphore semaphore = new Semaphore(2);
//        semaphore.availablePermits();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    if (semaphore.availablePermits() > 0) {
                        System.out.println("该线程可获取调用权限:" + Thread.currentThread().getName());
                    } else {
                        System.out.println("暂时无可用信号量,需要等待:" + Thread.currentThread().getName());
                    }
                    try {
                        semaphore.acquire();
                        Thread.sleep(100);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        semaphore.acquireUninterruptibly(2);
        System.out.println("执行结束,耗时:" + (System.currentTimeMillis() - start));
    }*/

    //***************************************first end************************************************

    //***************************************second begin************************************************

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new SemaphoreThread(semaphore));
        }
        semaphore.acquireUninterruptibly(2);
        System.out.println("执行时长=" + (System.currentTimeMillis() - start));

    }

    private static class SemaphoreThread implements Callable<String> {
        private Semaphore semaphore;

        SemaphoreThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public String call() throws Exception {
            if (semaphore.availablePermits() > 0) {
                System.out.println("可以获取执行权限+=" + Thread.currentThread().getName());
            } else {
                System.out.println("无可用信号量,需要等待+=" + Thread.currentThread().getName());
            }
            semaphore.acquire();
            Thread.sleep(10);
            semaphore.release();
            return "";
        }
    }

}