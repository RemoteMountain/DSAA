package com.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 递归  //描述
 * @Author : Liwang  //作者
 * @Date: 2020-06-17 14:25  //时间
 */
public class Recursion {

    //最终推荐人
    /*public long findRootReferrerId(long actorId) {
        Long referrerId = select referrer_id from[ table]where actor_id = actorId;
        if (referrerId == null) {
            return actorId;
        }
        return findRootReferrerId(referrerId);
    }*/

    int depth = 0;

    //座位排数
    public int row(int n) {
        ++depth;

        //防止递归堆栈溢出，设置递归深度。
        if (depth > 1000) {
            throw new RuntimeException();
        }


        if (n == 1) {
            return 1;
        }
        return row(n - 1) + 1;
    }

    public int row2(int n) {
        int ret = 1;

        for (int i = 2; i <= n; i++) {
            ret = ret + 1;
        }

        return ret;
    }

    Map<Integer, Integer> hasSolvedList = new HashMap();

    //下n阶楼梯有几种方式,每次可以下一阶或者两阶
    public Integer stairs(Integer n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        //防止递归过程中的重复计算
        if (hasSolvedList.containsKey(n)) {
            return hasSolvedList.get(n);
        }
        int ret = stairs(n - 1) + stairs(n - 2);
        hasSolvedList.put(n, ret);
        return ret;
    }

    public Integer stairs2(Integer n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}
