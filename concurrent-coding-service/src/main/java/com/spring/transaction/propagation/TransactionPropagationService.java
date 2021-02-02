package com.spring.transaction.propagation;/**
 * @author
 * @since 2020-11-04 14:45
 */

import com.spring.transaction.OperationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName UseJdbcWithoutTransactionService.java
 * @Description
 * @createTime 2020年11月04日 14:45:00
 */

@Service
public class TransactionPropagationService {



    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-mysql.xml");
        OperationPropatationService operationService =
                (OperationPropatationService) context.getBean("operationPropatationService");

//        operationService.queryScore();
       //事务测试
//        operationService.mulitOperation();
        operationService.requestNew();


    }



}
