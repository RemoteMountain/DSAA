package com.linkedlist.doublelist;

import java.util.LinkedList;

/**
 * @Description : 双向链表  //描述
 * @Author : Liwang  //作者
 * @Date: 2020-05-02 21:38  //时间
 */
public class DoubleList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    private DNode<T> head;
    private DNode<T> tail;
    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public DoubleList(){
        this.head = new DNode<T>();
        this.tail = new DNode<T>();
    }

    private class DNode<T>{
        T item;
        DNode<T> next;
        DNode<T> prev;

        public DNode(T item) {
            this.item = item;
        }

        public DNode(){
            this.prev = null;
            this.next = null;
        }

        DNode(DNode<T> prev, T element, DNode<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
