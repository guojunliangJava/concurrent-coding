/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestSingleton
 * Author:   guojunliang
 * Date:     2019/4/24 18:44
 * Description: 测试单利
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.TestSingleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试单例〉
 * 参考;https://www.jianshu.com/p/e3b1269fd75e
 * 参考:https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650123793&idx=1&sn=6ee37f4c6d071da6bf64fea3a11d394f&chksm=f36bb330c41c3a266c4cc6dfc7d4a9ee506a14bb98aad7822c053c56c04a5b20452fc3a07481&mpshare=1&scene=1&srcid=&key=593393174013ce6da734574325a0b6292a503a5da468cfcbed60209c9ad2969f060cff300bf4cb0f61f3499fe936b0ca56bb5ae3ed3e7c6c4d5f4c9a6dc4b2c3d5f6e6cb2ca0789302732806f2bd03e7&ascene=1&uin=MjYzMDAxODM0MQ%3D%3D&devicetype=Windows+7&version=62060739&lang=zh_CN&pass_ticket=G5SwmugNLBAt409FhGHPCYQy4dIwO6RfxVqzCeQb3Fel3EpYnaFPQfT7kEzkYRfX
 *
 * @author guojunliang
 * @create 2019/4/24
 * @since 1.0.0
 */
public class TestSingleton {
    private TestSingleton() {
    }

//饿汉模式1
   /* private static TestSingleton instance = new TestSingleton();

    public static TestSingleton getInstance() {
        return instance;
    }*/

//饿汉模式2
   /* private static TestSingleton instance;

    static {
        instance = new TestSingleton();
    }

    public static TestSingleton getInstance() {
        return instance;
    }*/

//懒汉模式:非线程安全
    /*private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (null == instance) {
            instance = new TestSingleton();
        }
        return instance;
    }*/
   /* //懒汉模式:使用同步锁方法
    private static TestSingleton instance;
    public static synchronized TestSingleton getInstance() {
        if (null == instance) {
            instance = new TestSingleton();
        }
        return instance;
    }*/

    /* //懒汉模式:双重判断锁机制
     private static TestSingleton instance;

     public static TestSingleton getInstance() {
         if (null == instance) {
             synchronized (TestSingleton.class) {
                 if (null == instance) {
                     instance = new TestSingleton();
                 }
             }
         }
         return instance;
     }*/
    //静态内部类来实现:就是使用了lazy-loading
  /* static {
       System.out.println("outc class static block exucuted");
   }
    private static class SingletonHolder {
        private static final TestSingleton INSTANCE = new TestSingleton();

        static {
            System.out.println("inner static class static block exucuted");
        }
    }

    public static final TestSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }*/
/*//使用枚举的方式   
    private enum SingletonEnum {
        INSTANCE;
        private TestSingleton TestSingleton;

        SingletonEnum() {
            TestSingleton = new TestSingleton();
        }

        private TestSingleton getInstance() {
            return TestSingleton;
        }
    }

    public static final TestSingleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }*/

  /*  private static final AtomicReference<TestSingleton> INSTANCE = new AtomicReference<TestSingleton>();

    public static TestSingleton getInstance() {
        for (; ; ) {
            TestSingleton testSingleton = INSTANCE.get();
            if (null != testSingleton) {
                return testSingleton;
            }

            testSingleton = new TestSingleton();
            if (INSTANCE.compareAndSet(null, testSingleton)) {
                return testSingleton;
            }
        }
    }*/

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        int forEachCount = 50000;
        final CountDownLatch countDownLatch = new CountDownLatch(forEachCount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < forEachCount; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
//                    TestSingleton TestSingleton = getInstance();
//                    System.out.println("TestSingleton=" + TestSingleton);
//                    ThreadPoolAnalysis.printThreadPoolAnalysis(executorService);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("耗时=" + (System.currentTimeMillis() - start));
    }

}