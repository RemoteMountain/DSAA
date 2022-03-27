package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 */
public class LC21_MergeTwoLists {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
