package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/4 17:41
 * 跳跃游戏 II
 */
public class Jump0045 {

    /*
    给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

     */
    //解法一 ：顺藤摸瓜
    //大部分都是这个思路，贪婪算法，我们每次在可跳范围内选择可以使得跳的更远的位置。
    public int jump(int[] nums) {

        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);

            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }

        return steps;


    }

    /*
    我们知道最终要到达最后一个位置，然后我们找前一个位置，遍历数组，
    找到能到达它的位置，离它最远的就是要找的位置。然后继续找上上个位置，最后到了第 0 个位置就结束了。
    至于离它最远的位置，其实我们从左到右遍历数组，第一个满足的位置就是我们要找的。
     */

    public int jump2(int[] nums) {
        //要找的位置
        int position = nums.length - 1;
        int steps = 0;
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Jump0045 jump0045 = new Jump0045();
        int[] nums = {2, 3, 1, 1, 4};
        int res = jump0045.jump2(nums);
        System.out.println(res);
    }
}
