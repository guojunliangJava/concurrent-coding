/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestConcurrentHashMap
 * Author:   guojunliang
 * Date:     2019/4/28 18:06
 * Description: concurrentHashMap测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈concurrentHashMap测试〉
 *
 * @author guojunliang
 * @create 2019/4/28
 * @since 1.0.0
 */
public class TestConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","1");

    }

}