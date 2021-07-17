package com.niuke.advance.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//基于搜索二叉树的实现
public class TreeMapTest {

    public static void main(String[] args) {
        //按照key实现的Comparable接口的compareTo顺序遍历，也是这种顺序组织key的
        TreeMap<String, String> map = new TreeMap<>();
        map.put("zuo", "31");
        map.put("cheng", "32");
        map.put("yun1", "33");
        map.put("yun", "33");
        map.put("yun2", "33");

        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }

        System.out.println("-----------------------------------");
        //按照key在桶内下标顺序遍历
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(3, "33");
        hmap.put(4, "31");
        hmap.put(2, "32");
        hmap.put(5, "31");
        hmap.put(1, "31");

        for (Map.Entry<Integer, String> entry :
                hmap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }

        /*System.out.println(index(hash(Integer.valueOf(1))));
        System.out.println(index(hash(Integer.valueOf(2))));
        System.out.println(index(hash(Integer.valueOf(3))));
        System.out.println(index(hash(Integer.valueOf(4))));
        System.out.println(index(hash(Integer.valueOf(5))));
        System.out.println(index(hash(Integer.valueOf(6))));*/


    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static int index(int hash){
        return (16 - 1) & hash;
    }
}
