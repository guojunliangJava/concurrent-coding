/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UUidTest
 * Author:   guojunliang
 * Date:     2019/5/5 14:28
 * Description: uuid生成
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jd.jr.access.concurrent;

import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈uuid生成〉
 *
 * @author guojunliang
 * @create 2019/5/5
 * @since 1.0.0
 * SNOWFlake生成uuid相关参考:https://segmentfault.com/a/1190000011282426#articleHeader2
 * 源码:https://github.com/downgoon/snowflake
 */
public class UUidTest {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid);
    }

    public synchronized static void c() {

    }

}