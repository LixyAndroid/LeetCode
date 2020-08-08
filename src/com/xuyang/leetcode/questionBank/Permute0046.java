package com.xuyang.leetcode.questionBank;


import java.util.*;

/**
 * @author Li Xuyang
 * @date 2020/8/8 14:17
 *
 * 入门级别回溯算法
 * 全排列
 */
public class Permute0046 {
    //给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        //Stack<Integer> path = new Stack<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        //  所有数都填完了
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            //下一层
            dfs(nums, len, depth + 1, path, used, res);
            //回溯
            path.removeLast();
            used[i] = false;
        }

    }

        public void backtrack(int n,
                              ArrayList<Integer> output,
                              List<List<Integer>> res,
                              int first) {
            // 所有数都填完了
            if (first == n)
                res.add(new ArrayList<Integer>(output));
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }

        public List<List<Integer>> permute2(int[] nums) {
            List<List<Integer>> res = new LinkedList();

            ArrayList<Integer> output = new ArrayList<Integer>();
            for (int num : nums)
                output.add(num);

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

}
