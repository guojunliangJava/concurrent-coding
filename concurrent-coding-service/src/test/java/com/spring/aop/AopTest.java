package com.spring.aop;/**
 * @author
 * @since 2020-07-03 14:08
 */

import com.spring.aop.service.IhelloWorldService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AopTest.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年07月03日 14:08:00
 */
public class AopTest {

    @Test
    public void testAnnotationBeforeAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/advice2.xml");
        IhelloWorldService helloworldService =
                ctx.getBean("helloWorldService", IhelloWorldService.class);
        helloworldService.sayAdvisorBefore("before");
        helloworldService.sayAdvisorBefore("before","join",1);


        System.out.println("======================================");
    }

}
