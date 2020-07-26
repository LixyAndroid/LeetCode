package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/7/26 09:48
 * 数字 1 的个数
 */
public class CountDigitOne0233 {
    //给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
    public int countDigitOne(int n) {
        if (n < 0) {
            return 0;
        }
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
