package com.java.base;/**
 * @author
 * @since 2020-09-17 17:25
 */

import java.util.*;

/**
 * @author guojl
 * @version 1.0.0
 * @ClassName ListTest.java
 * @Description
 * @createTime 2020年09月17日 17:25:00
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        for (int i = 0; i < userNames.size(); i++) {
            if (i == 1) {
                userNames.add("test");
            }
        }
        System.out.println(userNames);

        /*for (int i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).equals("HollisChuang")) {
                userNames.remove(i);
            }
        }
        System.out.println(userNames);*/


       /* for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        System.out.println(userNames);*/

        /*List<String> userNames1 = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
            add("test");
        }};

        Iterator<String> iterator = userNames1.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("调用第一次iterator.next()获取到元素:="+element);
            System.out.println("调用第二次iterator.next()获取到元素="+iterator.next());
        }
*/
       /* Iterator<String> iterator = userNames1.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("HollisChuang")) {
                userNames1.remove(iterator.next());
            }`
        }*/

        List<String> userNamesList = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        ListIterator<String> listIterator = userNamesList.listIterator();
        while (listIterator.hasNext()) {
            String userName = listIterator.next();
            if (userName.equals("Hollis")) {
                listIterator.add("test");
            }
        }
        System.out.println(userNamesList);


        List<String> userNamesList1 = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        for(int i=0;i<userNamesList1.size();i++){
            if (userNamesList1.get(i).equals("Hollis")) {
                userNamesList1.add("test");
            }
        }
        System.out.println(userNamesList1);


    }


}
