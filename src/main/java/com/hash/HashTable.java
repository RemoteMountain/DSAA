package com.hash;

import java.util.HashMap;

public class HashTable<K,V> {

    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * 初始化散列表数组
     */
    private Entry<K, V>[] table;

    /**
     * 实际元素数量
     */
    private int size = 0;



    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_INITAL_CAPACITY];
    }

    public void put(K key,V value){
        int index = hash(key);
        Entry<K,V> p;
        //数组下标为空，直接插入到index
        if ((p=table[index]) == null){
            table[index] = new Entry(key,value,null);
            size++;
        }
        else {
            do {
                //待插入key已经存在，直接覆盖value
                if (p.key == key){
                    p.value = value;
                    return;
                }
                p = p.next;
            }while (p != null);

            //插入到链表头部
            Entry<K, V> head = table[index];
            table[index] = new Entry(key, value, head);
            size++;
        }

        if (size > table.length){
            resize();
        }
    }

    public V get(K key){
        int index = hash(key);
        Entry<K,V> p;
        if ((p=table[index]) == null){
            return null;
        }else {
            do {
                if (p.key == key){
                    return p.value;
                }
                p = p.next;
            }while (p != null);
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);
        Entry<K,V> p;
        if ((p=table[index]) == null){
            return;
        }else {
            //待删除结点前驱结点
            Entry<K,V> pre;
            do {
                pre = p;
                if (p.key == key){
                    //头结点删除方式
                    if (p==table[index]){
                        table[index] = p.next;
                    }
                    //非头结点删除
                    pre.next = p.next;
                }
                size--;
                p = p.next;
            }while (p != null);
        }
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[table.length * 2];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while (e != null){
                int index = hash(e.key);
                if (table[index] == null){
                    table[index] = new Entry<>(e.key,e.value,null);
                }
                table[index] = new Entry<>(e.key, e.value, table[index]);
            }
        }
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    static class Entry<K,V>{

        final K key;

        V value;

        Entry<K,V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
