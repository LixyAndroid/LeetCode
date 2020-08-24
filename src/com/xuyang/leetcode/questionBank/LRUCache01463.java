package com.xuyang.leetcode.questionBank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/8/24 13:21
 * LRU缓存机制
 */
public class LRUCache01463 {
    //定义存储键值的双向链表
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    //在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，
    // 这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    public LRUCache01463(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部结点
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在，先通过哈希表定位，在移到头部
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            //添加至头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //如果超出容量，删除双向链表的尾部结点
                DLinkNode tail = removeTail();
                //删除哈希表的对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    private void addToHead(DLinkNode node) {

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //移除结点
    private void removeNode(DLinkNode node) {
        //改变前一个结点的next指针，指向当前待删除的next
        node.prev.next = node.next;
        //改变下一个结点的prev指针，指向当前待删除的prev
        node.next.prev = node.prev;
        //删除完成
    }

    //移到到头部
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);

    }

    private DLinkNode removeTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }


}
