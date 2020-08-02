package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/2 19:09
 * 剑指 Offer 63. 股票的最大利润
 */
public class MaxProfit63 {
    //假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    //暴力
    public int maxProfit(int[] prices) {
        int maxPrices = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxPrices = Math.max(maxPrices, prices[j] - prices[i]);
                }

            }
        }
        return maxPrices;
    }

    //动态规划
    //profit=max(profit,prices[i]−min(cost,prices[i])
    public int maxProfit2(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for (int price : prices) {
            //最低价格
            cost = Math.min(cost, price);
            //最大的利润
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
