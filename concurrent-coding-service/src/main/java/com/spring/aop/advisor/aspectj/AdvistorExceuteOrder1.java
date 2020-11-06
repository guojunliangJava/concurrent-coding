package com.spring.aop.advisor.aspectj;/**
 * @author
 * @since 2020-10-22 20:45
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName AdvistorExceuteOrder.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月22日 20:45:00
 */
@Aspect
@Component
@Order(0)
public class AdvistorExceuteOrder1 {



    @Before("execution(* greetTo(..))")
    public void beforeAdvice2(){
        System.out.println("AdvistorExceuteOrder1:执行前置增强:beforeAdvice2");
    }

    @Before("execution(* greetTo(..))")
    public void beforeAdvice1(){
        System.out.println("AdvistorExceuteOrder1:执行前置增强:beforeAdvice1");
    }

    //TODO 比较@Before 以及@Around执行顺序



    @Around("execution(* greetTo(..))")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AdvistorExceuteOrder1:执行环绕增强:aroundAdvice2:begin");
        proceedingJoinPoint.proceed();
        System.out.println("AdvistorExceuteOrder1:执行环绕增强:aroundAdvice2:end");

    }
    //TODO 比较顺序:@After 以及:@AfterReturning


    @AfterReturning("execution(* greetTo(..))")
    public void afterReturningAdvice() throws Throwable {
        System.out.println("AdvistorExceuteOrder1:执行后置增强:afterReturningAdvice");
    }

    @After("execution(* greetTo(..))")
    public void afterAdvice() throws Throwable {
        System.out.println("AdvistorExceuteOrder1:执行final增强test:afterAdvice");
    }



}
