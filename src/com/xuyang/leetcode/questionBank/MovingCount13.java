package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/8/16 10:40
 * 剑指 Offer 13. 机器人的运动范围
 */
public class MovingCount13 {

    /*
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
    一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

     */

    //深度优先遍历
    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    //易推出机器人可 仅通过向右和向下移动，访问所有可达解,暂时不理解，四个全加，即上下左右都dfs
    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= m || j >= n || k < digitSum(i) + digitSum(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) +
                dfs(i - 1, j, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited);
    }

    public int digitSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        MovingCount13 movingCount13 = new MovingCount13();
        int res = movingCount13.movingCount(20, 20, 6);
        System.out.println(res);
    }
}
