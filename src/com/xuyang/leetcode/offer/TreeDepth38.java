package com.xuyang.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/3/27 15:41
 * 二叉树的深度
 */
public class TreeDepth38 {

    //输入一棵二叉树，求该树的深度。
    // 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
    // 最长路径的长度为树的深度

    //递归方式
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        //这个+1很关键，使得可以一层+1
        return Math.max(left, right) + 1;
    }
    //非递归
    /*
        利用队列，count是当前的结点，nextcount是当前深度总的结点
        【总是要遍历到当前深度的最后一个结点，深度才加1】
     */

    public  int treeDepth2(TreeNode root){

            if (root==null){
                return 0;
            }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int d=0,count = 0,nextcount = q.size();

        while (q.size()!=0){
            TreeNode t =q.poll();
            count++;
            if (t.left!=null){
                q.add(t.left);
            }

            if (t.right!=null){
                q.add(t.right);
            }

            if (count==nextcount){
                d++;
                count = 0;
                nextcount = q.size();
            }
        }
        return  d;

    }
}
