package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/7/23 20:56
 * 64. 最小路径和
 */
public class MinPathSum0064 {
    //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //说明：每次只能向下或者向右移动一步。
    public static int minPathSum(int[][] grid) {
        //判空
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        //初始值
        dp[0][0] = grid[0][0];

        //根据问题赋值
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //动态规划条件
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1}};
        //int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

}
