package com.spring.component.autowired;/**
 * @author
 * @since 2020-10-13 14:43
 */

import org.springframework.stereotype.Component;

/**
 * @ClassName Dog.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月13日 14:43:00
 */
@Component
public class Dog implements Animal {
    @Override
    public String getName() {
        return "dog";
    }
}
