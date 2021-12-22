package com.leetcode.sq;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//前 K 个高频元素

/**
 * 1、元素频率统计
 * 2、频率排序
 */
public class LC347_TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
