package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/28 21:33
 * 平衡二叉树
 */
public class IsBalanced_Solution38 {
    //输入一棵二叉树，判断该二叉树是否是平衡二叉树。

    /*
    平衡二叉树的左右子树也是平衡二叉树，
    那么所谓平衡就是左右子树的高度差不超过1.
     */
    public boolean isBalanced_Solution(TreeNode root) {
        return -1!=depth(root);
    }

    public int depth(TreeNode root) {
        //空树也可以
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        if (left == -1) {
            //如果发现字数不平衡之后就没有必要进行下面的高度的求解了
            return -1;
        }

        int right = depth(root.right);
        if (right == -1) {
            //如果发现字数不平衡之后就没有必要进行下面的高度的求解了
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }else {
            return 1+(Math.max(left, right));
        }
    }
}
