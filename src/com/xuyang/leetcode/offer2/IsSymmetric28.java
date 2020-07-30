package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/30 23:00
 * 剑指 Offer 28. 对称的二叉树
 */
public class IsSymmetric28 {
    //root 的左边等于右边 && root 右边等于左边
    public boolean isSymmetric(TreeNode root) {

        return root == null || helper(root.left, root.right);

    }

    private boolean helper(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }

        return helper(L.left, R.right) && helper(L.right, R.left);
    }
}
