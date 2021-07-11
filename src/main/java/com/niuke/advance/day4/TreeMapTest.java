package com.niuke.advance.day4;

import java.util.Map;
import java.util.TreeMap;

//基于搜索二叉树的实现
public class TreeMapTest {

    public static void main(String[] args) {
        //按照key实现的Comparable接口的compareTo顺序遍历
        TreeMap<String, String> map = new TreeMap<>();
        map.put("zuo", "31");
        map.put("cheng", "32");
        map.put("yun", "33");
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }

    }
}
