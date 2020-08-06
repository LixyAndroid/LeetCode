package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/6 22:26
 * 剑指 Offer 65. 不用加减乘除做加法
 */
public class Add65 {
    //写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    //Q ： 若数字 a 和 b 中有负数，则变成了减法，如何处理？
    //A ： 在计算机系统中，数值一律用 补码 来表示和存储。
    // 补码的优势： 加法、减法可以统一处理（CPU只有加法器）。因此，以上方法 同时适用于正数和负数的加法 。
    // 位运算出来是十进制数字
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1; //c=进位
            a ^= b; //a=非进位和
            b = c; //b=进位
        }
        return a;
    }
}
