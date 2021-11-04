package com.leetcode.linkedlist;

public class LC206_ReverseList {
    private static class Node {
        private int val;
        private Node next;

        public Node(int data) {
            this.val = data;
        }
    }

    public void reverseList(Node head) {
        if (head == null) {
            return;
        }
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

    private static class DoubleNode {
        private int val;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(int data) {
            this.val = data;
        }
    }

    public void reverseList(DoubleNode head) {
        if (head == null) {
            return;
        }
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
    }



}
