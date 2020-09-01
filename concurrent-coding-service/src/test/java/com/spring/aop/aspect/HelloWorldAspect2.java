package com.spring.aop.aspect;/**
 * @author
 * @since 2020-07-03 13:34
 */

import org.aspectj.lang.annotation.*;

/**
 * @ClassName HelloWorldAspect2.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年07月03日 13:34:00
 */

@Aspect
public class HelloWorldAspect2 {


    @Pointcut(value="execution(* com.spring.aop.service..*.sayAdvisorBefore(..)) && args(param))",//&& args(param)
            argNames = "param")
    public void beforePointcut(String param) {

    }

    @Pointcut(value="@annotation(TimeAnnotation)))")
    public void beforePointcutAnnotation() {

    }

    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

    @Before(value = "beforePointcutAnnotation()")
    public void beforeAdvice1() {
        System.out.println("===========before advice param:");
    }


}
