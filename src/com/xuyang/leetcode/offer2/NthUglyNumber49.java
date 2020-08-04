package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/4 23:32
 * 剑指 Offer 49. 丑数
 */
public class NthUglyNumber49 {

    //我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    //动态规划
    /*
        xn+1=min(x×2,xb×3,xc×5)
        丑树队列可以认为，丑树 = 其他较小的丑树* 2或者另较小的丑树* 3或者另较小的丑树* 5 的最小值
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }

        return dp[n - 1];
    }
}

