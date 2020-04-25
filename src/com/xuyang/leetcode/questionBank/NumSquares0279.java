package com.xuyang.leetcode.questionBank;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/4/25 17:16
 * 完全平方数
 */
public class NumSquares0279 {

    /*
    动态规划
     */

        /*

    时间复杂度：O(n^2/3)，
    在主步骤中，我们有一个嵌套循环，其中外部循环是 n 次迭代，
    而内部循环最多需要 n^1/2迭代。
    空间复杂度：O(n)，使用了一个一维数组 dp。
     */

    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        //bottom case
        dp[0]=0;

        //pre-calculate the square numbers
        int max_square_index = (int)Math.sqrt(n)+1;
        int[] square_nums = new int[max_square_index];
        for (int i = 0; i < max_square_index; i++) {
            square_nums[i]=i*i;
        }


        for (int i = 0; i <=n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i<square_nums[s]){
                    break;

                }

                dp[i] = Math.min(dp[i],dp[i-square_nums[s]]+1);
            }

        }

        return dp[n];
    }



    public int numSquares2(int n){
        //默认初始化值都为0
        int[] dp = new  int[n+1];

        for (int i = 0; i <= n; i++) {
            //最坏的情况就是每次+1
            dp[i]=i;

            for (int j = 1; i-j*j>0; j++) {
                // 动态转移方程
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);

            }
        }

        return dp[n];
    }
}
