package com.spring.eventobject.eventlisenter;/**
 * @author
 * @since 2020-10-14 20:10
 */

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName MailSendListener.java
 * @Description
 * @createTime 2020年10月14日 20:10:00
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {


    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("向:" + mailSendEvent.getTo() + "发送邮件完成!");
    }
}
