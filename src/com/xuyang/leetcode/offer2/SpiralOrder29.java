package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/6/30 21:41
 * 顺时针打印矩阵
 */
public class SpiralOrder29 {
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    /*
    按层模拟
    可以将矩阵看成若干层，首先打印最外层的元素，其次打印次外层的元素，直到打印最内层的元素。
     */
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            //最后一行、列的时候，不需要了，前面已经加
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > left; row--) {
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

    public static void main(String[] args) {
        SpiralOrder29 spiralOrder29 = new SpiralOrder29();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] order = spiralOrder29.spiralOrder(matrix);
        System.out.println(Arrays.toString(order));
    }
}
