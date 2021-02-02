package com.spring.transaction.propagation;/**
 * @author
 * @since 2020-12-11 16:47
 */

import java.util.*;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.transaction.config.TransactionManagementConfigUtils;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName Operation.java
 * @Description
 * @createTime 2020年12月11日 16:47:00
 */

@Transactional
@Service
public class OperationPropatationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private DataSource dataSource;


    public void updateScore(String userName, int addScore) {
        String sql = "update t_user set user_name=?";
        //默认返回匹配行数,如果需要返回更新后行数,则需要在jdbc 连接中设置参数:useAffectedRows=true
        int updateNum = jdbcTemplate.update(sql, userName);
        System.out.println("updateScore=" + Thread.currentThread().getName() + "线程,更改userName=" + userName + ",更新行数:updateNum= " + updateNum);

    }

    public void updateScoreByCondition(String userName, String orgUserName) {
        String sql = "update t_user set user_name=? where  user_name=?";
        //默认返回匹配行数,如果需要返回更新后行数,则需要在jdbc 连接中设置参数:useAffectedRows=true
        int updateNum = jdbcTemplate.update(sql, userName, orgUserName);
        System.out.println("updateScore=" + Thread.currentThread().getName() + "线程,更改userName=" +
                userName + "更改条件:原userName=" + orgUserName + ",更新行数:updateNum= " + updateNum);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addScore() {
        String insertSql = "insert into t_user(user_name,score) values('张三',5)";
        jdbcTemplate.execute(insertSql);
        boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
//        System.out.println(isActiveFlag);
        System.out.println(transactionManager.getDataSource());


    }

    public void addScore(String user_name) {
        String insertSql = "insert into t_user(user_name,score) values('" + user_name + "',5)";
        jdbcTemplate.execute(insertSql);
        System.out.println("addScore=" + Thread.currentThread().getName() + "线程: " + user_name);

    }


    public int queryScore() {
        String sql = "select * from  t_user";
        //默认返回匹配行数,如果需要返回更新后行数,则需要在jdbc 连接中设置参数:useAffectedRows=true
        List<Map<String, Object>> sqlRowSet = jdbcTemplate.queryForList(sql);
//        System.out.println("queryScore=" + Thread.currentThread().getName() + "查询结果:" + sqlRowSet);

        boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println(transactionManager.getDataSource());

        return sqlRowSet.size();
    }

    /**
     * 事务的传播行为
     */
    @Transactional
    public void requestNew() {
        boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
//        System.out.println(isActiveFlag);
        System.out.println(DataSourceUtils.getConnection(dataSource));

        TransactionAspectSupport.currentTransactionStatus();
                TransactionSynchronizationManager.getCurrentTransactionIsolationLevel();
        TransactionSynchronizationManager.getResourceMap();
        TransactionSynchronizationManager.getSynchronizations();



                System.out.println(transactionManager.getDataSource());
        queryScore();
        addScore();

    }


}
