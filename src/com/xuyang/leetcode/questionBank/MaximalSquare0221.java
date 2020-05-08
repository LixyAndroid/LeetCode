package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/8 10:51
 * 最大正方形
 */
public class MaximalSquare0221 {

    /*
    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

     */

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows>0?matrix[0].length:0;
        //边长
        int maxSqlen=0;
        for (int i = 0; i <rows ; i++) { //行
            for (int j = 0; j < cols; j++) { //列

                //遇到1
                if (matrix[i][j]=='1'){
                    int sqlen = 1;
                    boolean flag=true;

                    //保证最大边长不会超过行树、列数
                    while (sqlen+i<rows&&sqlen+j<cols&&flag){


                        for (int k = j; k < sqlen+j; k++) {

                            if (matrix[i+sqlen][k]=='0'){
                                if (matrix[i+sqlen][k]=='0'){
                                    flag=false;
                                    break;
                                }
                            }

                        }

                        for (int l = i; l <sqlen+i ; l++) {

                            if (matrix[l][j+sqlen]=='0'){
                                flag = false;
                                break;
                            }

                        }

                        if (matrix[i+sqlen][j+sqlen]=='0'){
                            flag = false;
                            break;
                        }



                        if (flag){
                            sqlen++;
                        }


                    }

                    if (maxSqlen<sqlen){
                        maxSqlen = sqlen;
                    }



                }
            }

        }

        return maxSqlen*maxSqlen;
    }

    //官放
        public int maximalSquare2(char[][] matrix) {
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return maxSide;
            }
            int rows = matrix.length, columns = matrix[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == '1') {
                        // 遇到一个 1 作为正方形的左上角
                        maxSide = Math.max(maxSide, 1);
                        // 计算可能的最大正方形边长
                        int currentMaxSide = Math.min(rows - i, columns - j);
                        for (int k = 1; k < currentMaxSide; k++) {
                            // 判断新增的一行一列是否均为 1
                            boolean flag = true;
                            //对角线
                            if (matrix[i + k][j + k] == '0') {
                                break;
                            }
                            //m到k
                            for (int m = 0; m < k; m++) {
                                if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                maxSide = Math.max(maxSide, k + 1);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            int maxSquare = maxSide * maxSide;
            return maxSquare;
        }


    //动态规划
    /* 方法二：动态规划
        我们用一个例子来解释这个方法：

        0 1 1 1 0
        1 1 1 1 1
        0 1 1 1 1
        0 1 1 1 1
        0 0 1 1 1
    1，我们用 0 初始化另一个矩阵 dp，维数和原始矩阵维数相同；
    2，dp(i,j) 表示的是由 1 组成的最大正方形的边长；
    3，从 (0,0)(0,0) 开始，对原始矩阵中的每一个 1，我们将当前元素的值更新为
    dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1；
    4，我们还用一个变量记录当前出现的最大边长，这样遍历一次，
    找到最大的正方形边长 maxsqlen，那么结果就是 maxsqlen^2。

        //状态转移方程
        该点元素是1的话，就
        dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
     */


    /*
        可以使用动态规划降低时间复杂度。我们用 dp(i, j) 表示以(i,j) 为右下角，且只包含 1 的正方形的边长最大值。如果我们能计算出所有 dp(i,j) 的值，那么其中的最大值即为矩阵中只包含 11 的正方形的边长最大值，其平方即为最大正方形的面积。

那么如何计算 dpdp 中的每个元素值呢？对于每个位置 (i, j)(i,j)，检查在矩阵中该位置的值：

如果该位置的值是 0，则 dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中；

如果该位置的值是 1，则 dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：

dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1


此外，还需要考虑边界条件。如果 i 和 j 中至少有一个为 0，则以位置 (i, j)(i,j) 为右下角的最大正方形的边长只能是 1，因此 dp(i, j) = 1

以下用一个例子具体说明。原始矩阵如下。

0 1 1 1 0
1 1 1 1 0
0 1 1 1 1
0 1 1 1 1
0 0 1 1 1
对应的 dpdp 值如下。

0 1 1 1 0
1 1 2 2 0
0 1 2 3 1
0 1 2 3 2
0 0 1 2 3

         */
        public int maximalSquare3(char[][] matrix){
        int maxSide =0;
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return maxSide;
        }

        int rows = matrix.length,columns =matrix[0].length;
        int[][] dp = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {

                    if (matrix[i][j]=='1'){

                        if (i==0||j==0){
                            dp[i][j]=1;
                        }else {
                            dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                        }
                        maxSide = Math.max(maxSide,dp[i][j]);
                    }
                }
            }
            return maxSide*maxSide;
        }


    public static void main(String[] args) {
        MaximalSquare0221 maximalSquare0221 = new MaximalSquare0221();
        char[][] matrix = {{'1','1'},{'1','0'}};
        int res = maximalSquare0221.maximalSquare(matrix);
        System.out.println(res);
    }
}
