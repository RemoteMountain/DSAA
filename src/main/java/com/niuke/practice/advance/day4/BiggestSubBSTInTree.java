package com.niuke.practice.advance.day4;

//BS中的最大子BS
public class BiggestSubBSTInTree {

    public static Node biggestSubBST(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).head;
    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Node left = head.left;
        ReturnType leftRT = process(left);

        Node right = head.right;
        ReturnType rightRT = process(right);

        int includeItSelf = 0;
        if (leftRT.head == left &&
                rightRT.head == right &&
                head.value > leftRT.max &&
                head.value < rightRT.min) {
            includeItSelf = leftRT.size + rightRT.size + 1;
        }
        int p1 = leftRT.size;
        int p2 = rightRT.size;
        int maxSize = Math.max(Math.max(p1, p2), includeItSelf);

        Node maxHead = p1 > p2 ? leftRT.head : rightRT.head;
        if (maxSize == includeItSelf) {
            maxHead = head;
        }
        return new ReturnType(maxSize, maxHead,
                Math.min(Math.min(leftRT.min, rightRT.min), head.value),
                Math.max(Math.max(leftRT.max, rightRT.max), head.value));
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType {
        private int size; //BS节点数
        private Node head; //BS头节点
        private int min; //BS右子树最小值
        private int max; //BS左字数最大值

        public ReturnType(int a, Node b, int c, int d) {
            this.size = a;
            this.head = b;
            this.min = c;
            this.max = d;
        }
    }


}
