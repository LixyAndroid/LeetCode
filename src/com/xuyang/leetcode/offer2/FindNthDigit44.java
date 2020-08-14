package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/14 21:52
 * 剑指 Offer 44. 数字序列中某一位的数字
 */
public class FindNthDigit44 {
    //数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    //请写一个函数，求任意第n位对应的数字。


    //根据以上分析，可将求解分为三步：
    //
    //确定 n 所在 数字 的 位数 ，记为 digit ；
    //确定 n 所在的 数字 ，记为 num；
    //确定 n 是 num中的哪一数位，并返回结果。
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;

        //1. 确定所求数位的所在数字的位数
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        //2. 确定所求数位所在的数字
        long num = start + (n - 1) / digit;
        //3. 确定所求数位在 numnum 的哪一数位
        return Long.toString(num).charAt((n - 1) % digit) - '0';


    }
}
