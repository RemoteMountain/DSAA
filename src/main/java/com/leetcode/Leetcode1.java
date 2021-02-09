package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description :   //描述
 * @Author : Liwang  //作者
 * @Date: 2021-02-09 17:25  //时间
 */
public class Leetcode1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int i = 0;
        for (int num : nums) {
            map.put(nums[i], i);
            i++;
        }
        int n = nums.length;
        int[] ass = new int[2];
        for (int j = 0; j < n; j++) {
            int x = nums[j];
            int y = target - x;
            if (map.containsKey(y)){
                ass[0] = j;
                ass[1] = map.get(y);
                break;
            }

        }
        return ass;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] sum = twoSum(nums, 6);
        System.out.println(sum[0]);
        System.out.println(sum[1]);
        Map<Integer, Integer> map = new HashMap();
        map.put(3,1);
        System.out.println(map.containsKey(3));
    }

}
