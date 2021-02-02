package com.spring.beanfactory;/**
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

    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }

    public CircleB getCircleB() {
        return circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }
}
