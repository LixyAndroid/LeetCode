package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/8/17 15:29
 * 剑指 Offer 65. 不用加减乘除做加法
 */
public class Add65 {
    //观察发现，无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）。
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;// c = 进位
            a ^= b; // a = 非进位和
            b = c;
        }
        return a;
    }
}
