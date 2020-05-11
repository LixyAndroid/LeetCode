package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/11 16:00
 * Pow(x, n)
 */
public class MyPow0050 {

    //实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    //分治，找到子问题
    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;

    }

    public static double myPow(double x, int n) {
        long N = n;
        return N>=0?quickMul(x,N):1.0/quickMul(x,-N);
    }



    public static double quickMul2(double x, long N) {
        double ans = 1.0;
        //贡献的初始值为x
        double x_contribute =x;
        //在对N进行二进制拆分的同时，计算答案
        while (N>0){
            if (N%2==1){
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans*=x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *=x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N/=2;
        }
        return ans;

    }

    public static double myPow2(double x, int n) {
        long N = n;
        return N>=0?quickMul2(x,N):1.0/quickMul2(x,-N);
    }


    public static void main(String[] args) {
        System.out.println(myPow2(2.00000, 3));
    }
}

