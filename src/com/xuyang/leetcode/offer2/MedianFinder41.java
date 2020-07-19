package com.xuyang.leetcode.offer2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/7/19 23:36
 * 剑指 Offer 41. 数据流中的中位数
 */
public class MedianFinder41 {

    //如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    // 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。


    //优先队列 / 堆

    /**
     * initialize your data structure here.
     */
    Queue<Integer> A, B;
    public MedianFinder41() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }


    public static void main(String[] args) {
        MedianFinder41 medianFinder41 = new MedianFinder41();
        medianFinder41.addNum(-1);
        double res = medianFinder41.findMedian();
        System.out.println(res);
        medianFinder41.addNum(-2);
         res = medianFinder41.findMedian();
        System.out.println(res);
        medianFinder41.addNum(-3);
        res = medianFinder41.findMedian();
        System.out.println(res);
        medianFinder41.addNum(-4);
        res = medianFinder41.findMedian();
        System.out.println(res);
        medianFinder41.addNum(-5);
        res = medianFinder41.findMedian();
        System.out.println(res);
    }



}
