package com.spring.aop.advisor;/**
 * @author
 * @since 2020-10-19 20:10
 */

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName GreetIntroductionInterceptor.java
 * @Description
 * @createTime 2020年10月19日 20:10:00
 */
public class GreetIntroductionInterceptor extends DelegatingIntroductionInterceptor implements MonitorSwitch {

    private ThreadLocal<Boolean> switchFlag = new ThreadLocal<>();


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (null != switchFlag.get() && switchFlag.get()) {
            System.out.println("开启监控拦截!!!");
            return super.invoke(mi);
        }
        return super.invoke(mi);
    }

    @Override
    public void setMonitorSwitch(boolean monitorSwitchFlag) {
        switchFlag.set(monitorSwitchFlag);
    }
}
