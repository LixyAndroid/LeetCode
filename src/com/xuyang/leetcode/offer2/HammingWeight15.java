package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/15 10:47
 * 剑指 Offer 15. 二进制中1的个数
 */
public class HammingWeight15 {
    //请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
    // 例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
    public static int hammingWeight(int n) {

        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;

        }
        return cnt;
    }

    /*
    初始化数量统计变量 res = 0。
    循环逐位判断： 当 n = 0时跳出。
    res += n & 1 ： 若 n \& 1 = 1，则统计数 res 加一。
    n >>= 1 ： 将二进制数字 n 无符号右移一位（ Java 中无符号右移为 ">>>" ） 。
    返回统计数量 res 。

     */
    public static int hammingWeight2(int n) {

        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            n >>>= 1;

        }
        return cnt;
    }

    public static void main(String[] args) {
        int res = hammingWeight2(9);
        System.out.println(res);
    }
}
