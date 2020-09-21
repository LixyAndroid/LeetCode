package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/9/21 15:49
 * 把二叉搜索树转换为累加树
 */
public class ConvertBST0538 {
    //给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
    // 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。


    /*
    本题中要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和。
    这样我们只需要反序中序遍历该二叉搜索树，记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。
     */

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
