package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/1 22:05
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor68 {

    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */


    //观察发现， 情况 1. 可合并至 3. 和 4. 内，详见文章末尾代码。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /*
    递归解析：
    终止条件：
    当越过叶节点，则直接返回 null ；
    当 root 等于 p, q ，则直接返回 root ；
    递推工作：
    开启递归左子节点，返回值记为 left ；
    开启递归右子节点，返回值记为 right ；
    返回值： 根据 left 和 right ，可展开为四种情况；
       1, 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
       2,当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
       3, 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
          1,p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
          2,p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
        4,当 left 不为空 ， right 为空 ：与情况 3. 同理；
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) return null; // 1.
        if (left == null) return right; // 3.
        if (right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }

}
