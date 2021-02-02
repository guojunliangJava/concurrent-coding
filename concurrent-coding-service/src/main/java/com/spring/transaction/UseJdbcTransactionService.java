package com.spring.transaction;/**
 * @author
 * @since 2020-11-04 14:45
 */

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName UseJdbcWithoutTransactionService.java
 * @Description
 * @createTime 2020年11月04日 14:45:00
 */

@Service
public class UseJdbcTransactionService {



    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-mysql.xml");
        OperationService operationService =
                (OperationService) context.getBean("operationService");

//        operationService.queryScore();
       //事务测试
//        operationService.mulitOperation();
        operationService.mulitOperation1();


    }



}
