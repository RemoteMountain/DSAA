package com.leetcode.hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 */
public class LC155_MinStack {

    private Stack<Integer> data = new Stack();
    private Stack<Integer> min = new Stack();


    public LC155_MinStack() {
    }

    public void push(int val) {
        if (min.isEmpty()) {
            min.push(val);
        } else if (val <= getMin()) {
            min.push(val);
        } else {
            min.push(getMin());
        }
        data.push(val);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
