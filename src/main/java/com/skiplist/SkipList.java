package com.skiplist;

/**
 * @Description : 跳表  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-02-03 11:14  //时间
 */
public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private SkipListNode head;

    public SkipList() {
        head = new SkipListNode(-1);
    }

    public void add(int num) {
        int length = head.forward.length;
        while (num <= head.value) {


            length--;
        }

    }


    class SkipListNode {
        private SkipListNode[] forward;
        private SkipListNode backward;
        private int value;

        public SkipListNode(int value) {
            this.value = value;
            forward = new SkipListNode[randomLevel()];

        }


        private int randomLevel() {
            int level = 1;
            while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
                level++;
            }
            return level;
        }

    }

}
