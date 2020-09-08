package com.xuyang.leetcode.questionBank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/5/25 21:12
 * LRU缓存机制
 */
public class LRUCache0146 {


    /*
    运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。


进阶:

你是否可以在O(1) 时间复杂度内完成这两种操作？

     */

    //手写双向链表
    class DLinkedNode {
        int key;
        int value;
        //前后指针
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache0146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部结点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //如果key不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加进哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            //如果key存在，先通过哈希表定位，在修改value,并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
