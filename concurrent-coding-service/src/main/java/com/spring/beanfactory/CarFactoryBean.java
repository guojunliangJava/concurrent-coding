package com.spring.beanfactory;/**
 * @author
 * @since 2020-10-13 10:56
 */

import org.springframework.beans.factory.FactoryBean;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName CarBeanFactory.java
 * @Description
 * @createTime 2020年10月13日 10:56:00
 */
public class CarFactoryBean implements FactoryBean<Car1> {

    private String carInfo;


    @Override
    public Car1 getObject() throws Exception {
        Car1 car = new Car1();
        String[] carInfoArrays = carInfo.split(",");
        car.setBrand(carInfoArrays[0]);
        car.setColor(carInfoArrays[1]);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car1.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
