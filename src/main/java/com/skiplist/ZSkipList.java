package com.skiplist;

/**
 * @Description : 跳跃表  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-01-28 18:02  //时间
 */
public class ZSkipList {
    private ZSkipListNode head; //头节点
    private ZSkipListNode tail; //尾节点
    private long length; //节点个数
    private int level;  //最大层数

    public ZSkipList() {
        head = new ZSkipListNode(null,0);
        head.level = new ZSkipListNode.ZSkipListLevel[4];

    }

    public void add(String element, double score) {


    }


    class ZSkipListNode { // 节点
        private ZSkipListLevel[] level; //节点的层
        private ZSkipListNode backward; // 后退指针，只有一个
        private double score; //有序节点分值
        private String element; //节点保存的对象

        public ZSkipListNode(String element, double score){
            this.element = element;
            this.score = score;
            this.level = new ZSkipListLevel[4];
        }


        class ZSkipListLevel { //层
            private ZSkipListNode forward; //前进指针，数量与节点层数相同
            private int span; //跨度
        }
    }


}
