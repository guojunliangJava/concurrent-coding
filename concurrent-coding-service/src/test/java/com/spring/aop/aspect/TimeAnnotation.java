package com.spring.aop.aspect;

import java.lang.annotation.*;

/**
 * @author
 * @since 2020-07-03 15:15
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface TimeAnnotation {

}
