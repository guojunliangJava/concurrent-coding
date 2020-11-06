package com.spring.aop.advisor.aspectj;/**
 * @author
 * @since 2020-10-21 10:35
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName AroundAspect.java
 * @Description
 * @createTime 2020年10月21日 10:35:00
 */
@Aspect
public class AroundAspect {

    @Around("execution(* greetTo(..)) && target(com.spring.aop.advisor.Waiter)")
    public void aroundAdvisior( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("begin around advistor:args=" + proceedingJoinPoint.getArgs()
                + ",target=" + proceedingJoinPoint.getTarget().getClass()
                + ",siginature=" + proceedingJoinPoint.getSignature().getName());
        Object returnObj = proceedingJoinPoint.proceed();
        System.out.println("end around advisior=" + returnObj);

    }
}
