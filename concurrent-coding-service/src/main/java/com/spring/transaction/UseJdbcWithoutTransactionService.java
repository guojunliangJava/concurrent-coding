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
public class UseJdbcWithoutTransactionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int addScore) {
        String sql = "update t_user set score=9 where user_name=?";
        //默认返回匹配行数,如果需要返回更新后行数,则需要在jdbc 连接中设置参数:useAffectedRows=true
        int updateNum = jdbcTemplate.update(sql,  userName);
        System.out.println(updateNum);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-mysql.xml");
        UseJdbcWithoutTransactionService useJdbcWithoutTransactionService =
                (UseJdbcWithoutTransactionService) context.getBean("useJdbcWithoutTransactionService");
        useJdbcWithoutTransactionService.addScore("jone",3);

        JdbcTemplate  jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String insertSql = "insert into t_user(user_name,score) values('张三',5)";
        jdbcTemplate.execute(insertSql);


        String querySql = "select * from t_user";
        List<Map<String, Object>>  queryResult = jdbcTemplate.queryForList(querySql);
        System.out.println(queryResult);


    }
}
