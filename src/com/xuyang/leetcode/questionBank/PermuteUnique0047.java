package com.xuyang.leetcode.questionBank;

import java.util.*;

/**
 * @author Li Xuyang
 * @date 2020/8/8 14:49
 * 全排列 II
 */
public class PermuteUnique0047 {
    //给定一个可包含重复数字的序列，返回所有不重复的全排列。
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        //排序(升序，降序都可以)，为了剪枝方便
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;


    }
    /*
    1.break

    用break语句可以bai使流程跳出switch语句体，也可du以用break语句在循环结构终止本层循环体zhi，从而dao提前结束本层循环。

    使用说明：

    （1）只能在循环体内和switch语句体内使用break；

    （2）当break出现在循环体中的switch语句体内时，起作用只是跳出该switch语句体，并不能终止循环体的执行。若想强行终止循环体的执行，可以在循环体中，但并不在switch语句中设置break语句，满足某种条件则跳出本层循环体。

    2.continue

    continue语句的作用是跳过本次循环体中余下尚未执行的语句，立即进行下一次的循环条件判定，可以理解为仅结束本次循环。
    注意：continue语句并没有使整个循环终止。
     */

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            //剪枝条件：i>0,是为了保证nums[i-1]有意义
            //写!used[i - 1]是因为nums[i-1]在深度优先遍历但过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,used,path,res);
            used[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        PermuteUnique0047 solution = new PermuteUnique0047();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }

}
