package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/4/12 15:40
 * 滑动窗口的最大值
 */
public class MaxInWindows63 {
    /*
    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        if (num==null||num.length==0){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (size<=0){
            return res;
        }
        int cnt = 0;
        while (cnt<num.length-size+1){
            int temp = num[cnt];
            for (int i = cnt; i < cnt+size; i++) {

                if (num[i]>temp){
                    temp = num[i];
                }

                if (i==cnt+size-1){
                    res.add(temp);
                }

            }

            cnt++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] num={2,3,4,2,6,2,5,1};

        MaxInWindows63 maxInWindows63 = new MaxInWindows63();

        ArrayList<Integer> res = maxInWindows63.maxInWindows(num,1);

        System.out.println(res);


    }
}
