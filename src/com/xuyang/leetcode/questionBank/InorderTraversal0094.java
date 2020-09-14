package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/9/14 15:11
 *  二叉树的中序遍历
 */
public class InorderTraversal0094 {
    //给定一个二叉树，返回它的中序 遍历。
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;

    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {

        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
