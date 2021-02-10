package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description :   //描述
 * @Author : Liwang  //作者
 * @Date: 2021-02-10 10:42  //时间
 */
public class SwardToOffer {

    /*剑指 Offer 03. 数组中重复的数字*/
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
