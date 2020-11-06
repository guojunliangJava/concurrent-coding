package com.spring.eventobject.eventlisenter;/**
 * @author
 * @since 2020-10-14 20:15
 */

import com.spring.learning.beanfactory.lifecycle.single.di.prototype.Boss;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName EventObjectAndEventLisenterTest.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月14日 20:15:00
 */
public class EventObjectAndEventLisenterTest {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-context.xml");

        System.out.println("模拟测试Spring EventObject以及EventListener相关 begin");

        MailSendEvent mailSendEvent =new MailSendEvent(ctx,"ax@qq.com");
        ctx.publishEvent(mailSendEvent);
        System.out.println("模拟测试Spring EventObject以及EventListener相关 end");
    }
}
