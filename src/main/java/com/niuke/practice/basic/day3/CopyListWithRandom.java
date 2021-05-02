package com.niuke.practice.basic.day3;

/**
 * @Description : 复制含有随机指针节点的链表  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-05-02 17:20  //时间
 */
public class CopyListWithRandom {

    /**
     * 通过hash表，key-原节点，val-复制节点
     *
     * @param head
     * @return
     */
    public static Node copyListWithRand1(Node head) {
        return null;
    }

    /**
     * 复制节点的随机节点是原节点随机节点的next指针
     *
     * @param head
     * @return
     */
    public static Node copyListWithRand2(Node head) {
        return null;
    }

    private static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        while (cur != null) {
            System.out.print(cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(9);
        Node node2 = new Node(0);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.rand = node2;
        node2.rand = node3;
        node3.rand = node4;
        node4.rand = node5;
        node5.rand = node1;
        printList(node1);

        Node copy = copyListWithRand1(node1);
        printList(copy);

    }

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }


}
