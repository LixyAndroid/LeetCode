package com.xuyang.leetcode.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Li Xuyang
 * @date 2020/8/10 23:26
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class MaxQueue {
    //请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
    //
    //若队列为空，pop_front 和 max_value需要返回 -1

    Deque<Integer> res, max;
    public MaxQueue() {
        res = new LinkedList<Integer>();
        max = new LinkedList<Integer>();
    }

    public int max_value() {
        if (max.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        res.addLast(value);
        //移除无用元素
        while (!max.isEmpty() && max.peekLast() < value) max.removeLast();
        //这里保证max里只有一个元素，并且是最大值
        max.addLast(value);

    }

    //删除头部元素
    public int pop_front() {
        if (res.isEmpty()) return -1;
        int temp = res.peekFirst();
        //这里好，在需要移除的时候，移除
        if (temp == max.peekFirst()) max.removeFirst();
        res.removeFirst();
        return temp;
    }
}
