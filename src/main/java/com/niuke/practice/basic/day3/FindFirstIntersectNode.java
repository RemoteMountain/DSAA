package com.niuke.practice.basic.day3;

/**
 * 链表相交
 */
public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next !=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                fast = head;
                return null;
            }
        }
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(getLoopNode(head).value);
    }
}
