package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/8/21 18:52
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < q.val) {//保证p 小 q大
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {//在 p,q之间
                break;
            }
        }
        return root;
    }
}
