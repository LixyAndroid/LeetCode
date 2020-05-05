package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/4 18:35
 * 盛最多水的容器
 */
public class MaxArea0011 {
    /*
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且 n 的值至少为 2。

     */
    public int maxArea(int[] height) {

        int S=0;
        for (int i = 0; i <height.length ; i++) {

            for (int j = 0; j < height.length; j++) {
                S = Math.max(S,Math.min(height[i],height[j])*Math.abs(j-i));
            }

        }
        return S;
    }
    //双指针
    public int maxArea2(int[] height) {
        int i=0,j=height.length-1,res=0;
        while (i<j){
            res = height[i]<height[j]?Math.max(res,(j-i)*height[i++]):
                    Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }

    }
