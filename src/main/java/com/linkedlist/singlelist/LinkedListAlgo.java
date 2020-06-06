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

    //链表中环的检测
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

    //两个有序的链表合并
    public static Node mergeTwoLists(Node l1,Node l2){
        Node soldier = new Node(0); //利用哨兵结点简化实现难度 技巧三
        Node p = soldier;
        while ( l1 != null && l2 != null){
            if (l1.data < l2.data){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;

    }

    //删除链表倒数第n个结点
    public static Node deleteLastKth(Node list,int k){
        /*Node soldier = new Node(0); //利用哨兵结点简化实现难度 技巧三
        Node p = soldier;
        //倒数第k个等于正着数第Length-K+1
        int length = 0;
        while (list != null){
            length++;
            list = list.next;
        }
        int a = length - k + 1;
        System.out.println("倒数第"+k+" = "+"正数第"+a);
        Node pre = list;
        //pre为要删除节点前驱jied
        while (a == 2){
            pre = pre.next;
            a--;
        }*/

        Node fast = list;
        int i = 1;
        while (fast != null && i < k){
            fast = fast.next;
            ++i;
        }
        if (fast == null) {
            return list;
        }
        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
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
        System.out.println(node1);
        Node node2 = createNode(2);
        Node node3 = createNode(3);
        Node node4 = createNode(4);
        Node node5 = createNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //deleteLastKth(node1,5);
        //node5.next = node1;
        //System.out.println(LinkedListAlgo.checkCircle(node1));
        //LinkedListAlgo.printAll(node1);
        //Node middleNode = LinkedListAlgo.findMiddleNode(node1);
        //System.out.println(middleNode);
        //Node reverse = LinkedListAlgo.reverse(node1);
        //System.out.println(reverse);
        //LinkedListAlgo.printAll(reverse);


        /*Node l11 = createNode(1);
        Node l12 = createNode(3);
        Node l13 = createNode(8);
        Node l14 = createNode(8);
        Node l15 = createNode(9);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        Node l21 = createNode(2);
        Node l22 = createNode(5);
        Node l23 = createNode(6);
        Node l24 = createNode(6);
        Node l25 = createNode(7);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;

        System.out.println(mergeTwoLists(l11,l21));*/
    }

    public static Node  createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }


}
