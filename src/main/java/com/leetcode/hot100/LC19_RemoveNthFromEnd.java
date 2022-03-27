package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 */
public class LC19_RemoveNthFromEnd {

    public static class ListNode {

        int val;

        ListNode next;


        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    //双指针法，快指针先走n步，之后，快慢一起走，当快指针到null，慢指针指向待删除结点
    //通过加入虚拟头节点，优化待删除节点为头节点的情况
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head) {
            head = head.next;
        } else {
            pre.next = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);

    }
}
