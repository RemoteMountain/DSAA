package com.niuke.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            map.put(i + "", i + "");
        }
        Set<Entry<String, String>> entrySets = map.entrySet();
        //HashMap无序
        for (Entry<String, String> entrySet : entrySets) {
            System.out.println(entrySet.getKey() + ":" + entrySet.getValue());
        }
    }
}
