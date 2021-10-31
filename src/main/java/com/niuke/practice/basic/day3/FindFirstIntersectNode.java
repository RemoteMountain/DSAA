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

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

    //入环点
    public static Node getLoopNode(Node head) {
        if (head == null) {
            return null;
        }
        return null;
    }


    //两个无环链表交点
    public static Node noLoop(Node head1, Node head2) {
        return null;
    }


    //两个有环链表节点
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        return null;
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
