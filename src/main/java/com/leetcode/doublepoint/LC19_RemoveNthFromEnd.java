package com.leetcode.doublepoint;


//移除链表倒数第N个节点
public class LC19_RemoveNthFromEnd {

    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = dummyNode, slow = dummyNode;
        int i = n + 1;
        while (fast != null && i > 0) {
            fast = fast.next;
            i--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }


}
