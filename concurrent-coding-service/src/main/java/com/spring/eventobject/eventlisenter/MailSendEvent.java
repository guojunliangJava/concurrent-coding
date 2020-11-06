package com.spring.eventobject.eventlisenter;/**
 * @author
 * @since 2020-10-14 20:05
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName MailSendEvent.java
 * @Description
 * @createTime 2020年10月14日 20:05:00
 */
public class MailSendEvent extends ApplicationContextEvent {

    private String to;

    public MailSendEvent(ApplicationContext source) {
        super(source);
    }

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
