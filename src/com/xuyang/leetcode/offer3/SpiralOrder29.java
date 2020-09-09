package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/9/9 14:18
 * 顺时针打印矩阵
 */
public class SpiralOrder29 {
    //按层模拟
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {

            return new int[0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }

            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {

                for (int colum = right - 1; colum > left; colum--) {
                    order[index++] = matrix[bottom][colum];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];

                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
