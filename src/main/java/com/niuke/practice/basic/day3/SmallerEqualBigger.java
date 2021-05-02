package com.niuke.practice.basic.day3;

/**
 * @Description : 链表分区  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-05-02 15:47  //时间
 */
public class SmallerEqualBigger {

    public static Node listPartition1(Node head, int pivot) {
        return null;
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
    }

    public static Node listPartition2(Node head, int pivot) {
        return null;
    }

    private static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(0);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        printList(head);
        Node node = listPartition2(head, 3);
        printList(node);
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


}
