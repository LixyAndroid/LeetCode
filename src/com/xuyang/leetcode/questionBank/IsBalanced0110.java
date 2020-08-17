package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/8/17 10:13
 * 平衡二叉树
 */
public class IsBalanced0110 {

    //本题只判断高度 平衡二叉树，AVL树其实还有值的约束
    /*
    给定一个二叉树，判断它是否是高度平衡的二叉树。

    本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return Math.max(depth(treeNode.left), depth(treeNode.right)) + 1;

    }
}
