package com.spring.transaction;/**
 * @author
 * @since 2020-12-11 16:47
 */

import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;
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
public class OperationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSourceTransactionManager transactionManager;


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

    public void addScore() {
        String insertSql = "insert into t_user(user_name,score) values('张三',5)";
        jdbcTemplate.execute(insertSql);
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
        System.out.println("queryScore=" + Thread.currentThread().getName() + "查询结果:" + sqlRowSet);


        boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
//        System.out.println("queryScore=" + Thread.currentThread().getName() + "是否事务开启:" + isActiveFlag);

        return sqlRowSet.size();
    }


    //测试事务生效
    public void mulitOperation() {

        boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println(Thread.currentThread().getName() + "线程:" + "isActiveFlag=" + isActiveFlag);
        int size = queryScore();
        addScore();
        queryScore();

        if (1 == 1) {
            throw new RuntimeException("throw Exception!!!");
        }
    }


    //测试事务生效
    @Transactional
    public void mulitOperation1() throws InterruptedException {
        boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println(Thread.currentThread().getName() + "线程:" + "是否开启事务isActiveFlag=" + isActiveFlag);

        queryScore();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //1.获取事务定义
                DefaultTransactionDefinition def = new DefaultTransactionDefinition();
                //2.设置事务隔离级别，开启新事务
                def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
                //隔离级别设置
                def.setIsolationLevel(Isolation.READ_COMMITTED.value());
//                def.setIsolationLevel(Isolation.REPEATABLE_READ.value());
                //3.获得事务状态
                TransactionStatus status = transactionManager.getTransaction(def);


                try {
                    //TODO 确定是否开启了事务
                    boolean isActiveFlag = TransactionSynchronizationManager.isActualTransactionActive();
                    System.out.println(Thread.currentThread().getName() + "线程:" + "事务是否开启=" + isActiveFlag);
                    //如果开启了事务,第一次查询不到新增的数据
                    queryScore();
//                AopContext.currentProxy()


                    try {
                        Thread.currentThread().sleep(Long.parseLong("10000"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //间隔10秒钟, 主线程中的addScore() 已经执行,但是事务还没有提交
//                如果开启了事务,并且事务的隔离级别是:可重复读,则读取不到主线程的新增数据
                    queryScore();

                    try {
                        Thread.currentThread().sleep(Long.parseLong("15000"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //再次间隔15秒,此时主线程的addScore() 相关事务已经提交
//                如果开启了事务,并且事务的隔离级别是:可重复读,则读取不到主线程的新增数据
                    queryScore();

                    updateScoreByCondition("子线程更改原数据库存在记录","存在数据测试");
                    System.out.println("子线程更新数据库已经存在的记录后查询");
                    queryScore();

                    updateScoreByCondition("子线程更改原数据库插入记录","insert测试");
                    System.out.println("子线程更新主线程插入的数据记录后查询");
                    queryScore();



                } finally {
                    transactionManager.commit(status);
                }


            }
        }).start();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateTimeStr = simpleDateFormat.format(new Date());
        addScore("insert测试");
        //查询
        queryScore();
//        updateScore("事务测试NEW1112", 1);
        Thread.currentThread().sleep(Long.parseLong("20000"));

        System.out.println(Thread.currentThread().getName() + "线程: execute finish!!!");

    }

    public void async() {


    }


}
