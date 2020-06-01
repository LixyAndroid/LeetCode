package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/6/1 21:19
 *  拥有最多糖果的孩子
 */
public class KidsWithCandies1431 {

    /*
    给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。

对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。

     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> res = new ArrayList<>();

        int index = 0;
        while (index<candies.length){
            boolean flag = true;
            for (int i = 0; i < candies.length; i++) {
                if (candies[index]+extraCandies<candies[i]){
                    res.add(false);
                    flag = false;
                    break;
                }

            }
            if (flag){
                res.add(true);
            }
            index++;
        }
        return res;


    }

    //找出最大值，然后让candies[i]+extraCandies和最大值比较
    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        int n =candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; i++) {
            maxCandies = Math.max(maxCandies,candies[i]);
        }

        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            ret.add(candies[i]+extraCandies>=maxCandies);
        }

        return ret;

    }

        public static void main(String[] args) {
        KidsWithCandies1431 kidsWithCandies1431 = new KidsWithCandies1431();
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies1431.kidsWithCandies(candies,extraCandies);
        System.out.println(res);
    }
}
