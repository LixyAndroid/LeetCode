package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/2 15:18
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Fib10 {
    //写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
    //自己的代码
    public static int fib(int n) {

        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 3; i <= n; i++) {
            int temp = c;
            a = b;
            b = temp;
            c = (a + b) % 1000000007;
        }
        return c;
    }

    //别人的代码
    public static int fib2(int n) {

        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;

        }
        return a;
    }

    //特慢
    public static int fib3(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return (fib3(n - 1) + fib3(n - 2))%1000000007;
    }

    public static void main(String[] args) {
        int res = fib3(48);
        System.out.println(res);
    }
}
