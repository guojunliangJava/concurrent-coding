package com.spring.aop.service;

import com.spring.aop.aspect.TimeAnnotation;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author
 * @since 2020-07-03 13:23
 */
public interface IhelloWorldService {

     void sayAdvisorBefore(String param);

     @TimeAnnotation
     void sayAdvisorBefore(String param, String name, Integer age);
}
