package com.spring.beanfactory.circle.setter;/**
 * @author
 * @since 2020-12-10 10:58
 */

/**
 * @ClassName CircleA.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年12月10日 10:58:00
 */
public class CircleB {

    private CircleC circleC;

    public CircleC getCircleC() {
        return circleC;
    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }
}
