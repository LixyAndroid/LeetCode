package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/15 10:58
 * 剑指 Offer 47. 礼物的最大价值
 */
public class MaxValue47 {
    /*
    在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
    你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

     */
    //动态规划
    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        //注意行列的赋值
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];

        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
        };
        int res = maxValue(grid);
        System.out.println(res);
    }
}
