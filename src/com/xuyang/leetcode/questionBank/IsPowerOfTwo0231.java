package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/8/16 10:33
 * 2的幂
 */
public class IsPowerOfTwo0231 {
    //给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    //O(logN)
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
