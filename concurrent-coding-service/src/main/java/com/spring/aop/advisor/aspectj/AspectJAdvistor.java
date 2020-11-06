package com.spring.aop.advisor.aspectj;/**
 * @author
 * @since 2020-10-20 15:46
 */

import org.aspectj.lang.annotation.*;

/**
 * @ClassName AspectJAdvistor.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月20日 15:46:00
 */
@Aspect
public class AspectJAdvistor {

    @Before("execution(* greetTo(..))")
    public void beforeAdvice(){
        System.out.println("How are you!");
    }
}
