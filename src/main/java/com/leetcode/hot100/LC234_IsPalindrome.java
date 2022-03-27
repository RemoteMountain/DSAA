package com.leetcode.hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表
 */
public class LC234_IsPalindrome {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        //链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        reverse(cur);
        cur = slow.next;
        boolean res = true;
        while (head != null && cur != null){
            if (head.value!= cur.value){
                res = false;
                break;
            }
        }
        reverse(slow.next);
        return res;
    }

    public void reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

    }
}
