/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreadPoolAnalysis
 * Author:   guojunliang
 * Date:     2019/4/23 19:40
 * Description: 线程池大小相关执行解析统计
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池大小相关执行解析统计〉
 *
 * @author guojunliang
 * @create 2019/4/23
 * @since 1.0.0
 */
public class ThreadPoolAnalysis {
    private static final Logger log = LoggerFactory.getLogger(ThreadPoolAnalysis.class);

    /**
     * 线程池执行大小统计
     */
    public static void printThreadPoolAnalysis(ExecutorService executorService) {
        try {
            if (executorService instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                System.out.println("线程池执行相关大小统计:当前活动线程数={" + threadPoolExecutor.getActiveCount() + "},当前排队队列数={" + threadPoolExecutor.getQueue().size() + "},需要执行任务数={" + threadPoolExecutor.getTaskCount() + "},执行完成任务数={" + threadPoolExecutor.getCompletedTaskCount() + "},所创建最大线程数={" + threadPoolExecutor.getLargestPoolSize() + "}");
            } else {
                System.err.println("线程池统计线程创建有误");
            }
        } catch (Exception e) {
            log.warn("线程池执行相关大小统计异常:", e.getMessage());
        }
    }
}