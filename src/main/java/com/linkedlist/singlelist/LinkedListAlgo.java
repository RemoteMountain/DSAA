package com.linkedlist.singlelist;

/**
 * @Description : *
 *    1) 单链表反转
 *  * 2) 链表中环的检测
 *  * 3) 两个有序的链表合并
 *  * 4) 删除链表倒数第n个结点
 *  * 5) 求链表的中间结点  //描述
 * @Author : Liwang  //作者
 * @Date: 2020-05-04 20:33  //时间
 */
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node list){
        Node pre = null;
        Node r = list;
        Node next = null;
        while (r != null){
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        return pre;
    }

    //找出链表中间节点
    public static Node findMiddleNode(Node list){
        if (list == null) {
            return null;
        }
        Node slow = list;
        Node fast = list;
        //偶数节点返回中间两个都可以
        //返回中间两个的后一个
        while (fast != null&& fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //返回中间两个的前一个
        /*while (fast.next != null&& fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }*/
        return slow;
    }

    public static boolean checkCircle(Node list){
        if (list == null) {
            return false;
        }
        Node slow = list;
        Node fast = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                return true;
            }

        }
        return false;
    }


    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = createNode(1);
        Node node2 = createNode(2);
        Node node3 = createNode(3);
        Node node4 = createNode(4);
        Node node5 = createNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node1;
        //System.out.println(LinkedListAlgo.checkCircle(node1));
        //LinkedListAlgo.printAll(node1);
        //Node middleNode = LinkedListAlgo.findMiddleNode(node1);
        //System.out.println(middleNode);
        Node reverse = LinkedListAlgo.reverse(node1);
        System.out.println(reverse);
        //LinkedListAlgo.printAll(reverse);
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


}
