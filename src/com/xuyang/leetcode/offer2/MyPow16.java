package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/31 21:39
 * 剑指 Offer 16. 数值的整数次方
 */
public class MyPow16 {
    // 实现函数double Power(double base, int exponent)，求base的exponent次方。
    // 不得使用库函数，同时不需要考虑大数问题。
    public static double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        //二分
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *=x;
            b >>=1;
        }

        return res;
    }

    public static void main(String[] args) {
        double res = myPow(2.0, 25);
        System.out.println(res);

    }
}
