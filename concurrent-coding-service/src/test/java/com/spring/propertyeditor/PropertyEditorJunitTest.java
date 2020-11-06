package com.spring.propertyeditor;/**
 * @author
 * @since 2020-10-14 15:01
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName PropertyEditorJunitTest.java
 * @Description
 * @createTime 2020年10月14日 15:01:00
 */
public class PropertyEditorJunitTest {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-bean.xml");

//        默认属性编辑器测试
        PropertyEditorTest propertyEditorTest = (PropertyEditorTest) ctx.getBean("propertyEditorTest");
        System.out.println(propertyEditorTest.getBigDecimal1());


//        自定义属性编辑器测试:com.spring.propertyeditor.CustomCarPropertyEditorSupport
        Boss boss = (Boss) ctx.getBean("boss1");
        System.out.println(boss.getCar().getBrand());

    }
}
