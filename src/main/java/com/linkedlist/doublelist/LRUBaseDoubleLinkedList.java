package com.linkedlist.doublelist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 基于双向链表的LRU  //描述
 * @Author : Liwang  //作者
 * @Date: 2020-05-18 15:12  //时间
 */
//如果一个数据在最近一段时间没有被用到，那么将来被使用到的可能性也很小，所以就可以被淘汰掉。
public class LRUBaseDoubleLinkedList<k, v> {


    private int capacity;
    private int size;
    private Map<k, Node<k, v>> nodeMap;
    private Node<k, v> head;
    private Node<k, v> tail;

    public LRUBaseDoubleLinkedList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException(String.valueOf(capacity));
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        //初始化头节点和尾节点，利用哨兵模式减少判断头结点和尾节点为空的代码
        Node headNode = new Node(null, null);
        Node tailNode = new Node(null, null);
        headNode.next = tailNode;
        tailNode.pre = headNode;
        this.head = headNode;
        this.tail = tailNode;
    }

    //添加数据到缓存中
    public void put(k key, v value) {
        Node<k, v> node = nodeMap.get(key);
        //key存在于缓存中，删除当前key，并加入到链表头部
        if (node != null) {
            moveToHead(node);
        } else {
            //缓存满了
            if (size >= capacity) {
                //删除最后一个节点
                removeElemAtEnd();
            }
            //添加节点到链表头部
            node = new Node<>(key, value);
            addToHead(node);
            nodeMap.put(key, node);
            size++;
        }
    }

    //从缓存中获取数据
    public Node get(k key) {
        Node<k, v> node = nodeMap.get(key);
        //将最近访问的数据添加到链表头部
        if (node != null) {
            moveToHead(node);
        }
        return node;
    }

    //删除尾节点
    private void removeElemAtEnd() {
        Node node = tail.pre;
        removeFromList(node);
        //从缓存中移除改key
        nodeMap.remove(node.key);
        size--;
    }

    //移动节点到头部
    private void moveToHead(Node<k, v> node) {
        removeFromList(node);
        addToHead(node);
    }

    //添加节点到头部
    private void addToHead(Node<k, v> node) {
        Node next = head.next;
        next.pre = node;
        node.next = next;
        node.pre = head;
        head.next = node;
    }

    //移除节点
    private void removeFromList(Node<k, v> node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;

    }


    private static class Node<k, v> {
        private k key;
        private v value;
        private Node next;
        private Node pre;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LRUBaseDoubleLinkedList<String,String> doubleLinkedList = new LRUBaseDoubleLinkedList(5);
        doubleLinkedList.put("lw","cxzm");
        doubleLinkedList.put("lw","cxzm1");
        doubleLinkedList.put("lw","cxzm2");
        doubleLinkedList.put("lw","cxzm3");
        doubleLinkedList.put("lw","cxzm4");
        doubleLinkedList.put("lw","cxzm5");
        Node lw = (LRUBaseDoubleLinkedList.Node) doubleLinkedList.get("lw");
        System.out.println(lw.value);
    }


}
