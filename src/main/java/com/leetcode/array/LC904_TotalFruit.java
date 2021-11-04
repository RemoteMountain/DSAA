package com.leetcode.array;


import java.util.HashMap;

//水果成蓝
public class LC904_TotalFruit {

    public static int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        MyCounter counter = new MyCounter();
        while (r < fruits.length) {
            counter.add(fruits[r], 1);
            while (counter.size() >= 3) {
                counter.add(fruits[l], -1);
                if (counter.get(fruits[l]) == 0) {
                    counter.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    private static class MyCounter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }

    }

    public static void main(String[] args) {
        int[] f = {1, 2, 1};
        System.out.println(totalFruit(f));
    }

}
