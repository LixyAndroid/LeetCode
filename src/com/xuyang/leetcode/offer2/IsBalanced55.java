package com.xuyang.leetcode.offer2;

import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/7/29 22:50
 * 剑指 Offer 55 - II. 平衡二叉树
 */
public class IsBalanced55 {
    //输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

    //不能通过测试
    public boolean isBalanced(TreeNode root) {
        return recur(root) != 1;
    }

    private int recur(TreeNode root) {
        //用后序遍历的方式遍历二叉树的每个节点（从底至顶）,先左子树，再右子树，最后根节点，

        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }

        //最开始计算的是左子树最左侧的一个叶节点，其左右子节点不存在，left=0，right=0，满足条件，返回该叶节点的深度max(0,0)+1=1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1; //+1不能少

    }


    //比较好的
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        //左右子树也要平衡
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    //二叉树的深度
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


}
