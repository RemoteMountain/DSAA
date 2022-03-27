package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 相交链表 （两个无环链表）
 */
public class LC160_GetIntersectionNode {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int n = 0;
        while (curA != null) {
            n++;
            curA = curA.next;
        }
        while (curB != null) {
            n--;
            curB = curB.next;
        }
        if (curA != curB) {
            return null;
        }
        curA = n > 0 ? headA : headB;
        curB = curA == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            curA = curA.next;
        }
        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
