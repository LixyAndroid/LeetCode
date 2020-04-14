package com.xuyang.leetcode.offer;


import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/4/12 14:53
 * 二叉搜索树的第k个结点
 */
public class KthNode62 {

    //给定一棵二叉搜索树，请找出其中的第k小的结点。
    // 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。

    //二叉搜索树，要想中序遍历
    TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        //while部分为中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                //当前结点不为null，应该寻找左儿子
                stack.push(cur);
                cur = cur.left;
            } else {
                //当前节点null则弹出栈内元素，相当于按顺序输出最小值
                cur = stack.pop();
                if (--k <= 0) {//计数器功能
                    return cur;
                }
                cur = cur.right;
            }


        }
        return null;

    }
}
