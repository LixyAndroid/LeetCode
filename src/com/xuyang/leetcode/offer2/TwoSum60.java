package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/7/16 22:13
 * 剑指 Offer 60. n个骰子的点数
 */
public class TwoSum60 {
    /*
    把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     */

    //表示状态
    //找出状态转移方程
    //边界处理
    //基本思路如上，然后我们可以根据动态规划的套路：
    //1.构造dp数组：tmp[]为n个骰子的点数概率数组，pre[]为n-1个骰子的点数概率数组，一个骰子的点数概率数组显然是6个六分之一,不需要另设数组。
    //2.初始化dp数组：pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
    //3.构造状态转移方程:tmp[x+y]+=pre[x]*num[y];

    public double[] twoSum(int n) {
        double[] pre = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];

            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += pre[j] / 6;
                }
            }
            pre = temp;
        }

        return pre;
    }

    public double[] twoSum2(int n) {
        int dp[][] = new int[n + 1][6 * n + 1];//表示i个骰子掷出s点的次数
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;//表示一个骰子掷出i点的次数为1
        }
        for (int i = 2; i <= n; i++) {//表示骰子的个数
            for (int s = i; s <= 6 * i; s++) {//表示可能会出现的点数之和
                for (int j = 1; j <= 6; j++) {//表示当前这个骰子可能掷出的点数
                    if (s - j < i - 1) {//当总数还没有j大时，就不存在这种情况
                        break;
                    }
                    dp[i][s] += dp[i - 1][s - j];//当前n个骰子出现的点数之和等于前一次出现的点数之和加上这一次出现的点数
                }
            }
        }
        double total = Math.pow((double) 6, (double) n);//掷出n次点数出现的所有情况
        double[] ans = new double[5 * n + 1];//因为最大就只会出现5*n+1中点数
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;//第i小的点数出现的概率
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSum60 twoSum60 = new TwoSum60();
        double[] res = twoSum60.twoSum(3);
        System.out.println(Arrays.toString(res));
    }

}
