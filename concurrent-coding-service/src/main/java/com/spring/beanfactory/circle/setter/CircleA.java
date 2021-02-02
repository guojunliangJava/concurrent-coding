package com.spring.beanfactory.circle.setter;/**
 * @author
 * @since 2020-12-10 10:58
 */


/**
 * @author guojl
 * @version 1.0.0
 * @ClassName CircleA.java
 * @Description
 * @createTime 2020年12月10日 10:58:00
 */
public class CircleA {

    private CircleB circleB;

    public CircleB getCircleB() {
        return circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }

    public void  init(){
        System.out.println("init method execute....");
    }

    public void  destroy(){
        System.out.println("destroy method execute....");
    }

}
