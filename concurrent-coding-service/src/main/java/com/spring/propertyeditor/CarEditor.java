package com.spring.propertyeditor;/**
 * @author
 * @since 2020-10-14 15:40
 */

import java.beans.PropertyEditorSupport;

/**
 * @ClassName CarEditor.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年10月14日 15:40:00
 */
public class CarEditor extends PropertyEditorSupport {

    public void setAsText(String text) throws java.lang.IllegalArgumentException {

        String[] strings = text.split(",");
        Car car =  new Car();
        car.setBrand(strings[0]);
        car.setColor(strings[1]);

        setValue(car);
    }
}
