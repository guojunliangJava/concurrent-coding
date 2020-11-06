package com.spring.propertyeditor;/**
 * @author
 * @since 2020-10-14 15:16
 */

import java.beans.PropertyEditorSupport;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName CustomCarPropertyEditorSupport.java
 * @Description
 * @createTime 2020年10月14日 15:16:00
 */

public class CustomCarPropertyEditorSupport extends PropertyEditorSupport {

    public void setAsText(String text) throws java.lang.IllegalArgumentException {

        String[] strings = text.split(",");
        Car car =  new Car();
        car.setBrand(strings[0]);
        car.setColor(strings[1]);

        setValue(car);
    }

}
