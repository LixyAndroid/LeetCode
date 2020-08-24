package com.xuyang.leetcode.questionBank;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/8/24 13:07
 * LRU缓存机制
 */
//需要用到一个哈希表和一个双向链表
public class LRUCache01462 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache01462(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {

        return size() > capacity;
    }
}
