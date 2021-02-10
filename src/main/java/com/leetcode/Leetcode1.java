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

    /*1 两数之和*/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /*167. 两数之和 II - 输入有序数组
     */
    public static int[] twoSum2(int[] numbers, int target) {
        /*for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[0];*/
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high--;

            } else {
                low++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 24, 50, 79, 88, 150, 345};
        int[] sum = twoSum2(nums, 200);
    }

}
