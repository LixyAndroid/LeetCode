package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/8/21 18:45
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor682 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if (left == null) {//3
            return right;
        }
        if (right == null) {//4
            return left;
        }
        return root; // 2. if(left != null and right != null)

    }
}
