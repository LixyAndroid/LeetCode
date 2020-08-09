package com.xuyang.leetcode.offer2;

import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/8/9 17:29
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class VerifyPostorder33 {
    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    //后序遍历，左右根 二叉搜索树，中序有序即左根右
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postprder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postprder[p] < postprder[j]) {
            p++;
        }
        int m = p;
        while (postprder[p] > postprder[j]) {
            p++;
        }

        return p == j && recur(postprder, i, m - 1) && recur(postprder, m, j - 1);
    }

    //单调栈
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                //更新父结点
                root = stack.pop();
            }
            stack.add(postorder[i]);

        }
        return true;
    }

}
