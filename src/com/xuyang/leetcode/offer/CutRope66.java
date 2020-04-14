package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/14 09:15
 * 剪绳子
 */
public class CutRope66 {

    /*
    给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
    例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */

    //动态规划

    public int cutRope(int target) {

        if (target<2){
            return 0;
        }
        if (target==2){
            return 1;
        }
        if (target==3){
            return 2;
        }

        //申请辅助空间
        int[] products = new  int[target+1];
        //定义前几个初始变量的值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //进行动态规划，也就是从下向上进行求解
        int max = 0;
        for (int i = 4; i < target+1; i++) {

            for (int j = 1; j < i/2+1; j++) {
                max =Math.max(products[j]*products[i-j],max);
            }
            products[i] = max;
        }

        max = products[target];
        return max;


    }

    public static void main(String[] args) {
        CutRope66 cutRope66 = new CutRope66();
        int res = cutRope66.cutRope(8);
        System.out.println(res);
    }
}
