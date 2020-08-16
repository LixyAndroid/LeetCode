package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/16 15:29
 * 剑指 Offer 14- I. 剪绳子
 */
public class CuttingRope14 {
    /*
    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    //3是最优的
    //① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 3 。
    /*
    最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
    次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1+1 。
    最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为 2×2>3×1。
     */
    public int cuttingRope(int n) {
        if (n < 4) { //最少剪成两段
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    /*

     */
    //体会动态规划
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        int p = 1000000007;

        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    //动态规划优化
    public int integerBreak2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
