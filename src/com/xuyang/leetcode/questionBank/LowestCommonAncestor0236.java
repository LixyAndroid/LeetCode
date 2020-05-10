package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/10 10:06
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor0236 {


    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：
    “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
    （一个节点也可以是它自己的祖先）。”

     */
    //递归
    private TreeNode ans;
    public LowestCommonAncestor0236(){
        this.ans=null;
    }

    private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root==null){
            return false;
        }

        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);

        if ((lson&&rson)||((root.val==p.val||root.val==q.val)&&(lson||rson))){

            ans = root;
        }

        return lson||rson||(root.val==p.val||root.val==q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        this.dfs(root,p,q);
        return this.ans;
    }



    /**
     注意p,q必然存在树内, 且所有节点的值唯一!!!
     递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
     表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
     1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
     2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
     3. 左右子树返回值均为null, p和q均不在树中, 返回null
     **/

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
