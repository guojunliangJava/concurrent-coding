package com.spring.component.autowired;/**
 * @author
 * @since 2020-10-13 14:48
 */

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName AnimalResource.java
 * @Description
 * @createTime 2020年10月13日 14:48:00
 */
@Component
public class AnimalResource {

    @Autowired
    private Animal fish;

    @Autowired
    private List<Animal> animalList;

    @PostConstruct
    public void init() {
        System.out.println("init()=" + fish);
        System.out.println("init() animalList=" + animalList);
    }
}
