package com.xuyang.leetcode.offer2;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/7/30 23:28
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class KthLargest54 {
    ArrayList<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return list.get(list.size() - k);
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }


    private int res = 0, k = 0;

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs2(root);
        return res;
    }

    private void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root.right);

        if (k == 0) {
            //这里retyrn
            return;
        }
        if (--k == 0){
            //只是赋值，
            res = root.val;
        }
        dfs(root.left);
    }
}
