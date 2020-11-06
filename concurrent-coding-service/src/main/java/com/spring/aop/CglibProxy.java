package com.spring.aop;/**
 * @author
 * @since 2020-10-15 16:39
 */

import java.lang.reflect.Method;
import net.sf.cglib.proxy.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName CglibProxy.java
 * @Description
 * @createTime 2020年10月15日 16:39:00
 */
public class CglibProxy implements MethodInterceptor {
    private  Enhancer enhancer = new Enhancer();

    /**
     * 获取目标类的cglib代理
     *
     * @param targetClass
     * @return
     */
    public Object getProxy(Class targetClass) {
        //设置父类
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(this);
        //通过字节码技术创建cglib代理
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 动态代理 begin:className="+o.getClass().getName()+",methodName="+method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 动态代理 end");
        return result;
    }
}
